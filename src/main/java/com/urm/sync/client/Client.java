package com.urm.sync.client;

import static com.urm.Constants.MAX_RECONNECT_TIMES;
import static com.urm.Constants.ROLE_SLAVE;

import com.urm.StandardApplicationContext;
import com.urm.sync.client.handler.HeartBeatClientHandler;
import com.urm.sync.client.handler.SyncInfoHandler;
import com.urm.sync.codec.FacadeDecoder;
import com.urm.sync.codec.FacadeEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import java.nio.ByteOrder;
import java.util.concurrent.TimeUnit;

public class Client extends Thread {

  public static void main(String[] args) {
    new Client().start();
  }

  @Override
  public void run() {
    try {
      int port = 8080;
      connect(port, "127.0.0.1");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void connect(int port, String host) throws Exception {
    // Configure the client.
    EventLoopGroup group = new NioEventLoopGroup();
    ChannelFuture future = null;
    try {
      Bootstrap b = new Bootstrap();
      b.group(group)
          .channel(NioSocketChannel.class)
          .option(ChannelOption.TCP_NODELAY, true)
          .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 500)
          .handler(new LoggingHandler(LogLevel.INFO))
          .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
              ChannelPipeline p = ch.pipeline();
              //When the client accept less than one read request in 200 milliseconds,
              //we think has some network problem between client&server
              //then we count the reconnect times + 1 ;
              p.addLast(
                  new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 1024 * 128, 0, 2, 6, 0,
                      true))
                  .addLast("ping", new IdleStateHandler(20, 10, 0, TimeUnit.SECONDS))
//                  .addLast("ping", new IdleStateHandler(2500, 500, 0, TimeUnit.MILLISECONDS))
                  .addLast("decoder", new FacadeEncoder())
                  .addLast("encoder", new FacadeDecoder())
                  .addLast("heartbeat", new HeartBeatClientHandler())
                  .addLast("syncInfo",new SyncInfoHandler());
            }
          });

      future = b.connect(host, port).sync();
      future.channel().closeFuture().sync();
    } catch (Exception e) {
      //when reconnect times >3; do arbit.
      int counts = StandardApplicationContext.getInstance().getReconnectCounts();
      StandardApplicationContext.getInstance().setReconnectCounts(++counts);
      if (MAX_RECONNECT_TIMES < StandardApplicationContext.getInstance().getReconnectCounts()) {
        System.out.println("发起仲裁，我退出啦!");
        System.exit(0);
        //TODO do arbit ,if no reply --> system.out
        //               if let me out --> system.out
        //               if let me to be single --> change my role single refresh context;
        //
      }
    } finally {
      if (null != future) {
        if (future.channel() != null && future.channel().isOpen()) {
          future.channel().close();
        }
      }
      //If APP_ROlE is slave,reconnect ,else shutdownGracefully
      StandardApplicationContext.getInstance().setRole(ROLE_SLAVE);
      if (ROLE_SLAVE == StandardApplicationContext.getInstance().getRole()) {
        System.out.println("准备重连");
        connect(port, host);
        System.out.println("重连成功");
      } else {
        group.shutdownGracefully();
      }

    }
  }

}

