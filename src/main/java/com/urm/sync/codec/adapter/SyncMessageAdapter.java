package com.urm.sync.codec.adapter;

import com.urm.sync.codec.IAdapter;
import com.urm.sync.codec.entity.SyncInfo;
import com.urm.sync.codec.adapter.protocal.sbe.SyncMessageDecoder;
import com.urm.sync.codec.adapter.protocal.sbe.SyncMessageEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.agrona.concurrent.UnsafeBuffer;

public class SyncMessageAdapter implements IAdapter<String, Object> {

  private static final SyncMessageDecoder SYNC_MESSAGE_DECODER = new SyncMessageDecoder();
  private static final SyncMessageEncoder SYNC_MESSAGE_ENCODER = new SyncMessageEncoder();

  @Override
  public Map<String, Object> decode(ByteBuf byteBuf) {
    Map<String, Object> result = new HashMap<>();

    final UnsafeBuffer directBuffer = new UnsafeBuffer(byteBuf.nioBuffer());

    int bufferOffset = 0;
    //解码消息头
    MESSAGE_HEADER_DECODER.wrap(directBuffer, bufferOffset);
    final int actingBlockLength = MESSAGE_HEADER_DECODER.blockLength();
    final int templateId = MESSAGE_HEADER_DECODER.templateId();
    final int actingVersion = MESSAGE_HEADER_DECODER.version();

    bufferOffset += MESSAGE_HEADER_DECODER.encodedLength();
    //解码消息体
    SYNC_MESSAGE_DECODER.wrap(directBuffer, bufferOffset, actingBlockLength, actingVersion);

    SyncInfo syncInfo = new SyncInfo();

    syncInfo.setId(SYNC_MESSAGE_DECODER.id());
    syncInfo.setSequenceId(SYNC_MESSAGE_DECODER.sequenceId());
    syncInfo.setTimestamp(Long.parseLong(SYNC_MESSAGE_DECODER.timestamp()));
    syncInfo.setExchId(SYNC_MESSAGE_DECODER.exchId());
    syncInfo.setStkId(SYNC_MESSAGE_DECODER.stkId());
    syncInfo
        .setClosePrice(BigDecimal.valueOf(Double.parseDouble(SYNC_MESSAGE_DECODER.closePrice())));
    syncInfo.setNewPrice(BigDecimal.valueOf(Double.parseDouble(SYNC_MESSAGE_DECODER.newPrice())));
    syncInfo.setMaxOrderPrice(
        BigDecimal.valueOf(Double.parseDouble(SYNC_MESSAGE_DECODER.maxOrderPrice())));
    syncInfo.setMinOrderPrice(
        BigDecimal.valueOf(Double.parseDouble(SYNC_MESSAGE_DECODER.minOrderPrice())));
    syncInfo.setKnockAvgPrice(
        BigDecimal.valueOf(Double.parseDouble(SYNC_MESSAGE_DECODER.knockAvgPrice())));
    syncInfo.setTotalMktKnockQty(Integer.parseInt(SYNC_MESSAGE_DECODER.totalMktKnockQty()));

    result.put(TEMPLATE_ID, templateId);
    result.put(SyncInfo.class.getSimpleName(), syncInfo);

    return result;
  }

  @Override
  public ByteBuf encode(Map<String, Object> message) {
    final ByteBuffer byteBuffer = ByteBuffer
        .allocateDirect(SYNC_MESSAGE_ENCODER.sbeBlockLength() + 8);

    final UnsafeBuffer directBuffer = new UnsafeBuffer(byteBuffer);
    int bufferOffset = 0;

    //FRAME = HEAD + BODY
    //编码消息头
    MESSAGE_HEADER_ENCODER
        .wrap(directBuffer, bufferOffset)
        .blockLength(SYNC_MESSAGE_ENCODER.sbeBlockLength())
        .templateId(SYNC_MESSAGE_ENCODER.sbeTemplateId())
        .schemaId(SYNC_MESSAGE_ENCODER.sbeSchemaId())
        .version(SYNC_MESSAGE_ENCODER.sbeSchemaVersion());

    bufferOffset += MESSAGE_HEADER_ENCODER.encodedLength();

    //编码消息体
    SyncInfo syncInfo =
        (SyncInfo) message
            .get(SyncInfo.class.getSimpleName());

    SYNC_MESSAGE_ENCODER.wrap(directBuffer, bufferOffset);

    if (syncInfo != null) {
      SYNC_MESSAGE_ENCODER.id(syncInfo.getId())
          .sequenceId(syncInfo.getSequenceId())
          .timestamp(String.valueOf(syncInfo.getTimestamp()))
          .exchId(syncInfo.getExchId())
          .stkId(syncInfo.getStkId())
          .closePrice(String.valueOf(syncInfo.getClosePrice()))
          .newPrice(String.valueOf(syncInfo.getNewPrice()))
          .maxOrderPrice(String.valueOf(syncInfo.getMaxOrderPrice()))
          .minOrderPrice(String.valueOf(syncInfo.getMinOrderPrice()))
          .knockAvgPrice(String.valueOf(syncInfo.getKnockAvgPrice()))
          .totalMktKnockQty(String.valueOf(syncInfo.getTotalMktKnockQty()));
    }
    byteBuffer.limit();
    return Unpooled.wrappedBuffer(byteBuffer);
  }
}
