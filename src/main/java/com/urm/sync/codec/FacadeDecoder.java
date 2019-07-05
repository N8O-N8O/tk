package com.urm.sync.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacadeDecoder extends ByteToMessageDecoder {

  private static Logger logger = LoggerFactory.getLogger(FacadeDecoder.class);

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
      throws Exception {

    try {

      if (!check(in)) {
        return;
      }
      if (in.readableBytes()<8){
        return;
      }
      IAdapter<String,Object> adapter = AdapterManager.getInstance().createAdapter(in);

      Validate.notNull(adapter);
      // 方法结束，in对象会被正常释放掉
      Map<String,Object> result = adapter.decode(in);

      Validate.notNull(result);

      out.add(result);

    } catch (Exception e) {
      logger.error("消息解码失败! 原始字节流：{}. ", ByteBufUtil.hexDump(in), e);
    } finally {
      markReadFinish(in);
    }

  }

  /**
   * 设置读写完毕
   *
   * @param in
   */
  private void markReadFinish(ByteBuf in) {

    int all = in.readableBytes();

    in.readerIndex(all);

  }

  /**
   * 检查合法性
   *
   * @param in
   * @return
   */
  private boolean check(ByteBuf in) {

    if (in == null) {
      return false;
    }

    if (in.refCnt() == 0) {
      return false;
    }

    if (in.readableBytes() < 8) {
      return false;
    }

    return true;

  }

}
