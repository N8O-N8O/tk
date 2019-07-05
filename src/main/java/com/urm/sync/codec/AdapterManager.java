package com.urm.sync.codec;

import com.urm.sync.codec.adapter.HeartbeatAdapter;
import com.urm.sync.codec.adapter.SyncMessageAdapter;
import com.urm.sync.codec.adapter.protocal.sbe.HeartbeatMessageDecoder;
import com.urm.sync.codec.adapter.protocal.sbe.MessageHeaderDecoder;
import com.urm.sync.codec.adapter.protocal.sbe.SyncMessageDecoder;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.agrona.concurrent.UnsafeBuffer;

public final class AdapterManager {

  private MessageHeaderDecoder MESSAGE_HEADER_DECODER = new MessageHeaderDecoder();

  private Map<Integer, IAdapter<String,Object>> adapters = new ConcurrentHashMap<>();

  private AdapterManager(){
    init();
  }

  private static class AdapterManagerHolder{
    private static final AdapterManager manager = new AdapterManager();
  }

  public static AdapterManager getInstance(){
    return AdapterManagerHolder.manager;
  }

  private void init(){
    adapters.put(HeartbeatMessageDecoder.TEMPLATE_ID,new HeartbeatAdapter());
    adapters.put(SyncMessageDecoder.TEMPLATE_ID,new SyncMessageAdapter());
  }



  public IAdapter<String, Object> createAdapter(ByteBuf in) {

    return createAdapter(in.nioBuffer());

  }
  /**
   *
   *
   * @return
   */
  public IAdapter<String, Object> createAdapter(ByteBuffer byteBuffer) {

    final UnsafeBuffer directBuffer = new UnsafeBuffer(byteBuffer);
    //解码消息头
    MESSAGE_HEADER_DECODER.wrap(directBuffer, 0);
    //查找解码模版（写死）
    int templateId = MESSAGE_HEADER_DECODER.templateId();

    return createAdapter(templateId);

  }
  public IAdapter<String,Object> createAdapter(int templateId) {
    return adapters.get(templateId);
  }
}
