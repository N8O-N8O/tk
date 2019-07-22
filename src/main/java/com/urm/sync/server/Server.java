package com.urm.sync.server;

import com.urm.arbit.Arbit;
import com.urm.sync.SequenceMachine;
import com.urm.sync.codec.FacadeDecoder;
import com.urm.sync.codec.FacadeEncoder;
import com.urm.sync.codec.IAdapter;
import com.urm.sync.codec.adapter.protocal.sbe.SyncMessageDecoder;
import com.urm.sync.codec.entity.SyncInfo;
import com.urm.sync.server.handler.HeartBeatServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server extends Thread {

  private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
  private static final int BOSS_GROUP_THREADS = 1;
  private SequenceMachine sequenceMachine;
  private int port = 8099;
  private Arbit arbit;

  private Channel channel;

  private Server() {

  }

  public static void main(String[] args) {

    Server.getInstance().setPort(8099).setSequenceMachine(null).start();

  }

  public Arbit getArbit(){
    if (this.arbit==null){
      throw new RuntimeException("Server's Arbit must not null");
    }
    return this.arbit;
  }

  public Server setArbited(Arbit arbited){
    this.arbit = arbited;
    return this;
  }

  public Server setChannel(Channel channel) {
    this.channel = channel;
    return this;
  }

  public Server setSequenceMachine(SequenceMachine sequenceMachine) {
    this.sequenceMachine = sequenceMachine;
    return this;
  }


  private static class ServerHolder {

    private static final Server SERVER = new Server();
  }

  public static Server getInstance() {
    return ServerHolder.SERVER;
  }

  public Server setPort(int port) {
    if (port != 0) {
      this.port = port;
    }
    return this;
  }

  @Override
  public void run() {
    EventLoopGroup bossGroup = new NioEventLoopGroup(BOSS_GROUP_THREADS);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {

      HeartBeatServerHandler heartBeatServerHandler = new HeartBeatServerHandler(this);
      ServerBootstrap sbs = new ServerBootstrap()
          .group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .handler(new LoggingHandler(LogLevel.INFO))
          .localAddress(new InetSocketAddress(port))
          .childHandler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel ch) throws Exception {
              ChannelPipeline pipeline = ch.pipeline();
//              pipeline.addLast(new IdleStateHandler(2500, 200, 0, TimeUnit.MILLISECONDS))
              pipeline.addLast(new IdleStateHandler(10, 1, 0, TimeUnit.SECONDS))
                  .addLast("decoder", new FacadeDecoder())
                  .addLast("encoder", new FacadeEncoder())
                  .addLast("heartbeat", heartBeatServerHandler);
            }
          })
          // Specify the queue can accept the maximum number of links for 128
          .option(ChannelOption.SO_BACKLOG, 128)
          .childOption(ChannelOption.SO_KEEPALIVE, true);
      // Binding port, to receive incoming connections
      ChannelFuture future = sbs.bind(port).sync();
      future.channel().closeFuture().sync();
    } catch (Throwable e) {
      LOGGER.error("Netty服务器异常", e);
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }

  public void syncInfoToClient(SyncInfo syncInfo) {
    Map<String, Object> map = new HashMap();
    map.put(IAdapter.TEMPLATE_ID, SyncMessageDecoder.TEMPLATE_ID);
    syncInfo = new SyncInfo();
    syncInfo.setId("1");
//    syncInfo.setSequenceId(sequenceMachine.getSequenceId());
    syncInfo.setSequenceId("qwe");
    syncInfo.setTotalMktKnockQty(new BigDecimal("1203"));
    syncInfo.setKnockAvgPrice(BigDecimal.valueOf(Double.MAX_VALUE));
    syncInfo.setMinOrderPrice(BigDecimal.valueOf(Double.MAX_VALUE));
    syncInfo.setMaxOrderPrice(BigDecimal.valueOf(Double.MAX_VALUE));
    syncInfo.setNewPrice(BigDecimal.valueOf(Double.MAX_VALUE));
    syncInfo.setClosePrice(BigDecimal.valueOf(Double.MAX_VALUE));
    syncInfo.setStkId("123");
    syncInfo.setExchId("456");
    syncInfo.setTimestamp(1234L);
    map.put(SyncInfo.class.getSimpleName(), syncInfo);
    this.channel.writeAndFlush(map);
  }


}
