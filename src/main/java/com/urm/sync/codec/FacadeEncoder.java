package com.urm.sync.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacadeEncoder extends MessageToByteEncoder<Map<String,Object>> {

  private static Logger LOGGER = LoggerFactory.getLogger(FacadeEncoder.class);

  @Override
  protected void encode(ChannelHandlerContext ctx, Map<String,Object> msg, ByteBuf out) throws Exception {
    Object id = msg.get(IAdapter.TEMPLATE_ID);
    Validate.notNull(id);
    IAdapter<String,Object> adapter = AdapterManager.getInstance().createAdapter((int)id);
    ByteBuf result = adapter.encode(msg);
    out.writeBytes(result);
  }

}
