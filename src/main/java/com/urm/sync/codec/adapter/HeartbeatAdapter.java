package com.urm.sync.codec.adapter;

import com.urm.sync.codec.adapter.protocal.sbe.HeartbeatMessageEncoder;
import io.netty.buffer.ByteBuf;
import com.urm.sync.codec.IAdapter;
import io.netty.buffer.Unpooled;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.agrona.concurrent.UnsafeBuffer;

public class HeartbeatAdapter implements IAdapter<String, Object> {

  @Override
  public Map<String, Object> decode(ByteBuf byteBuf) {
    Map<String, Object> result = new HashMap<>();
    final UnsafeBuffer directBuffer = new UnsafeBuffer(byteBuf.nioBuffer());
    int bufferOffset = 0;
    // 解码消息头
    MESSAGE_HEADER_DECODER.wrap(directBuffer, bufferOffset);
    final int templateId = MESSAGE_HEADER_DECODER.templateId();
    bufferOffset += MESSAGE_HEADER_DECODER.encodedLength();
    result.put(TEMPLATE_ID, templateId);
    return result;
  }

  @Override
  public ByteBuf encode(Map<String, Object> message) {
    int bufferOffset = 0;
    // 心跳消息
    final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(8);
    final UnsafeBuffer directBuffer = new UnsafeBuffer(byteBuffer);
    // 心跳模版
    HeartbeatMessageEncoder heartbeatEncoder = new HeartbeatMessageEncoder();
    MESSAGE_HEADER_ENCODER.wrap(directBuffer, bufferOffset)
        .blockLength(heartbeatEncoder.sbeBlockLength())
        .templateId(heartbeatEncoder.sbeTemplateId())
        .schemaId(heartbeatEncoder.sbeSchemaId())
        .version(heartbeatEncoder.sbeSchemaVersion());
    byteBuffer.limit();
    return Unpooled.wrappedBuffer(byteBuffer);
  }
}
