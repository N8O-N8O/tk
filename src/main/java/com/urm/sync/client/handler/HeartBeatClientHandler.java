package com.urm.sync.client.handler;

import com.urm.StandardApplicationContext;
import com.urm.sync.codec.IAdapter;
import com.urm.sync.codec.adapter.protocal.sbe.HeartbeatMessageDecoder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {

  private static final Map<String, Object> HEARTBEAT = new HashMap<>();

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("client 连接 server 成功：" + LocalDateTime.now());
    //if reconnect success，set global variety reconnect_counts = 0;
    StandardApplicationContext.getInstance().setReconnectCounts(0);
    ctx.fireChannelActive();
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("Client 停止时间是：" + LocalDateTime.now());
    System.out.println("HeartBeatClientHandler channelInactive");
  }

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    System.out.println("client triggerd ：" + new Date());
    if (evt instanceof IdleStateEvent) {
      IdleStateEvent event = (IdleStateEvent) evt;
      if (event.state() == IdleState.READER_IDLE) {
        //When Server has no data message, it will be send a heartbeat message every 200 milliseconds,
        //so i set Client read_idle time 2000ms, 10 times of Server send cycle,
        //Once trigger Client read_idle, means lost connect with Server ,
        //So let the channel closed, and do reconnect 3 times;
        ctx.channel().close();
      } else if (event.state() == IdleState.WRITER_IDLE) {
        //Send a heartbeat message to Server every 500 milliseconds
        HEARTBEAT.put(IAdapter.TEMPLATE_ID, HeartbeatMessageDecoder.TEMPLATE_ID);
        ctx.channel().writeAndFlush(HEARTBEAT);
      }
    } else {
      super.userEventTriggered(ctx, evt);
    }
  }
}
