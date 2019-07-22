package com.urm.sync.server.handler;

import static com.urm.Constants.ROLE_MASTER;

import com.urm.sync.codec.IAdapter;
import com.urm.sync.codec.adapter.protocal.sbe.HeartbeatMessageDecoder;
import com.urm.sync.server.Server;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(HeartbeatMessageDecoder.class);

  private static final Map<String, Object> HEARTBEAT = new HashMap<>();

  private Channel channel;

  private Server server;

  public HeartBeatServerHandler(Server server) {
    this.server = server;
  }

  /**
   *  if ReadIdle .Initiation of Arbitration ,
   *  if writeIdle . supplement a heartbeat message to client;
   * @param ctx
   * @param evt
   * @throws Exception
   */
  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if (evt instanceof IdleStateEvent) {
      IdleStateEvent event = (IdleStateEvent) evt;
      if (event.state() == IdleState.WRITER_IDLE) {
        HEARTBEAT.put(IAdapter.TEMPLATE_ID, HeartbeatMessageDecoder.TEMPLATE_ID);
        this.channel.writeAndFlush(HEARTBEAT);
      } else if (event.state() == IdleState.READER_IDLE) {
        server.getArbit().initiationArbitration(2000L, TimeUnit.MILLISECONDS,ROLE_MASTER);
      }
    } else {
      super.userEventTriggered(ctx, evt);
    }
  }

  /**
   * TODO if exception Caught , closed.
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    LOGGER.error("heartbeat exception ", cause);
    ctx.close();
  }

  /**
   * if trigger channelActive ,hold channel ref in this object.
   * @param ctx
   * @throws Exception
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    Server.getInstance().setChannel(ctx.channel());
    this.channel = ctx.channel();
    super.channelActive(ctx);
  }
}
