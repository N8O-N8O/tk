package com.urm.sync.codec;

import com.urm.sync.codec.adapter.protocal.sbe.MessageHeaderDecoder;
import com.urm.sync.codec.adapter.protocal.sbe.MessageHeaderEncoder;
import io.netty.buffer.ByteBuf;
import java.util.Map;

public interface IAdapter<K, V> {

    String TEMPLATE_ID = "Id";

    MessageHeaderDecoder MESSAGE_HEADER_DECODER = new MessageHeaderDecoder();
    MessageHeaderEncoder MESSAGE_HEADER_ENCODER = new MessageHeaderEncoder();

    /**
     * 解码
     * 
     * @param byteBuf
     * @return
     */
    public Map<K, V> decode(ByteBuf byteBuf);

    /**
     * 编码
     *
     * @param message
     * @return
     */
    public ByteBuf encode(Map<K, V> message);

}