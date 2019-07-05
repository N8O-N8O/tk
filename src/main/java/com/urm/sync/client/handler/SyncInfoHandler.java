package com.urm.sync.client.handler;

import com.urm.sync.codec.IAdapter;
import com.urm.sync.codec.entity.SyncInfo;
import com.urm.sync.codec.adapter.protocal.sbe.SyncMessageDecoder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Map;
import org.apache.commons.lang.Validate;

public class SyncInfoHandler extends SimpleChannelInboundHandler<Map<String,Object>> {
  /**
   * if message equals heartbeat drop it . Simulate SimpleChannelInboundHandler to release resource
   * manual
   */
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Map<String, Object> msg) throws Exception {
    Object id = msg.get(IAdapter.TEMPLATE_ID);
    Validate.notNull(id);
    if ((int)id == SyncMessageDecoder.TEMPLATE_ID){
      //TODO do some business ,For example printout
      Object o = msg.get(SyncInfo.class.getSimpleName());
      Validate.notNull(o);
      if (o instanceof SyncInfo){
        System.out.println(((SyncInfo)o).toString());
      }
    }
  }
}
