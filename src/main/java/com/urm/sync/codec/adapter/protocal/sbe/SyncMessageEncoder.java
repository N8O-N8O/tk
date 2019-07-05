/* Generated SBE (Simple Binary Encoding) message codec */
package com.urm.sync.codec.adapter.protocal.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

@javax.annotation.Generated(value = {"com.urm.sync.codec.adapter.protocal.sbe.SyncMessageEncoder"})
@SuppressWarnings("all")
public class SyncMessageEncoder
{
    public static final int BLOCK_LENGTH = 266;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;

    private final SyncMessageEncoder parentMessage = this;
    private MutableDirectBuffer buffer;
    protected int offset;
    protected int limit;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public MutableDirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public SyncMessageEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        this.buffer = buffer;
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);

        return this;
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int idEncodingOffset()
    {
        return 0;
    }

    public static int idEncodingLength()
    {
        return 32;
    }

    public static byte idNullValue()
    {
        return (byte)0;
    }

    public static byte idMinValue()
    {
        return (byte)32;
    }

    public static byte idMaxValue()
    {
        return (byte)126;
    }

    public static int idLength()
    {
        return 32;
    }

    public void id(final int index, final byte value)
    {
        if (index < 0 || index >= 32)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 0 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String idCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putId(final byte[] src, final int srcOffset)
    {
        final int length = 32;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 0, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder id(final String src)
    {
        final int length = 32;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 0, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 0 + start, (byte)0);
        }

        return this;
    }

    public static int sequenceIdEncodingOffset()
    {
        return 32;
    }

    public static int sequenceIdEncodingLength()
    {
        return 32;
    }

    public static byte sequenceIdNullValue()
    {
        return (byte)0;
    }

    public static byte sequenceIdMinValue()
    {
        return (byte)32;
    }

    public static byte sequenceIdMaxValue()
    {
        return (byte)126;
    }

    public static int sequenceIdLength()
    {
        return 32;
    }

    public void sequenceId(final int index, final byte value)
    {
        if (index < 0 || index >= 32)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 32 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String sequenceIdCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putSequenceId(final byte[] src, final int srcOffset)
    {
        final int length = 32;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 32, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder sequenceId(final String src)
    {
        final int length = 32;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 32, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 32 + start, (byte)0);
        }

        return this;
    }

    public static int timestampEncodingOffset()
    {
        return 64;
    }

    public static int timestampEncodingLength()
    {
        return 23;
    }

    public static byte timestampNullValue()
    {
        return (byte)0;
    }

    public static byte timestampMinValue()
    {
        return (byte)32;
    }

    public static byte timestampMaxValue()
    {
        return (byte)126;
    }

    public static int timestampLength()
    {
        return 23;
    }

    public void timestamp(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 64 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String timestampCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putTimestamp(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 64, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder timestamp(final String src)
    {
        final int length = 23;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 64, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 64 + start, (byte)0);
        }

        return this;
    }

    public static int exchIdEncodingOffset()
    {
        return 87;
    }

    public static int exchIdEncodingLength()
    {
        return 6;
    }

    public static byte exchIdNullValue()
    {
        return (byte)0;
    }

    public static byte exchIdMinValue()
    {
        return (byte)32;
    }

    public static byte exchIdMaxValue()
    {
        return (byte)126;
    }

    public static int exchIdLength()
    {
        return 6;
    }

    public void exchId(final int index, final byte value)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 87 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String exchIdCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putExchId(final byte[] src, final int srcOffset)
    {
        final int length = 6;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 87, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder exchId(final String src)
    {
        final int length = 6;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 87, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 87 + start, (byte)0);
        }

        return this;
    }

    public static int stkIdEncodingOffset()
    {
        return 93;
    }

    public static int stkIdEncodingLength()
    {
        return 35;
    }

    public static byte stkIdNullValue()
    {
        return (byte)0;
    }

    public static byte stkIdMinValue()
    {
        return (byte)32;
    }

    public static byte stkIdMaxValue()
    {
        return (byte)126;
    }

    public static int stkIdLength()
    {
        return 35;
    }

    public void stkId(final int index, final byte value)
    {
        if (index < 0 || index >= 35)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 93 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String stkIdCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putStkId(final byte[] src, final int srcOffset)
    {
        final int length = 35;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 93, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder stkId(final String src)
    {
        final int length = 35;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 93, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 93 + start, (byte)0);
        }

        return this;
    }

    public static int closePriceEncodingOffset()
    {
        return 128;
    }

    public static int closePriceEncodingLength()
    {
        return 23;
    }

    public static byte closePriceNullValue()
    {
        return (byte)0;
    }

    public static byte closePriceMinValue()
    {
        return (byte)32;
    }

    public static byte closePriceMaxValue()
    {
        return (byte)126;
    }

    public static int closePriceLength()
    {
        return 23;
    }

    public void closePrice(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 128 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String closePriceCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putClosePrice(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 128, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder closePrice(final String src)
    {
        final int length = 23;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 128, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 128 + start, (byte)0);
        }

        return this;
    }

    public static int newPriceEncodingOffset()
    {
        return 151;
    }

    public static int newPriceEncodingLength()
    {
        return 23;
    }

    public static byte newPriceNullValue()
    {
        return (byte)0;
    }

    public static byte newPriceMinValue()
    {
        return (byte)32;
    }

    public static byte newPriceMaxValue()
    {
        return (byte)126;
    }

    public static int newPriceLength()
    {
        return 23;
    }

    public void newPrice(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 151 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String newPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putNewPrice(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 151, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder newPrice(final String src)
    {
        final int length = 23;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 151, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 151 + start, (byte)0);
        }

        return this;
    }

    public static int maxOrderPriceEncodingOffset()
    {
        return 174;
    }

    public static int maxOrderPriceEncodingLength()
    {
        return 23;
    }

    public static byte maxOrderPriceNullValue()
    {
        return (byte)0;
    }

    public static byte maxOrderPriceMinValue()
    {
        return (byte)32;
    }

    public static byte maxOrderPriceMaxValue()
    {
        return (byte)126;
    }

    public static int maxOrderPriceLength()
    {
        return 23;
    }

    public void maxOrderPrice(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 174 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String maxOrderPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putMaxOrderPrice(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 174, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder maxOrderPrice(final String src)
    {
        final int length = 23;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 174, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 174 + start, (byte)0);
        }

        return this;
    }

    public static int minOrderPriceEncodingOffset()
    {
        return 197;
    }

    public static int minOrderPriceEncodingLength()
    {
        return 23;
    }

    public static byte minOrderPriceNullValue()
    {
        return (byte)0;
    }

    public static byte minOrderPriceMinValue()
    {
        return (byte)32;
    }

    public static byte minOrderPriceMaxValue()
    {
        return (byte)126;
    }

    public static int minOrderPriceLength()
    {
        return 23;
    }

    public void minOrderPrice(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 197 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String minOrderPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putMinOrderPrice(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 197, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder minOrderPrice(final String src)
    {
        final int length = 23;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 197, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 197 + start, (byte)0);
        }

        return this;
    }

    public static int knockAvgPriceEncodingOffset()
    {
        return 220;
    }

    public static int knockAvgPriceEncodingLength()
    {
        return 23;
    }

    public static byte knockAvgPriceNullValue()
    {
        return (byte)0;
    }

    public static byte knockAvgPriceMinValue()
    {
        return (byte)32;
    }

    public static byte knockAvgPriceMaxValue()
    {
        return (byte)126;
    }

    public static int knockAvgPriceLength()
    {
        return 23;
    }

    public void knockAvgPrice(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 220 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String knockAvgPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putKnockAvgPrice(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 220, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder knockAvgPrice(final String src)
    {
        final int length = 23;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 220, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 220 + start, (byte)0);
        }

        return this;
    }

    public static int totalMktKnockQtyEncodingOffset()
    {
        return 243;
    }

    public static int totalMktKnockQtyEncodingLength()
    {
        return 23;
    }

    public static byte totalMktKnockQtyNullValue()
    {
        return (byte)0;
    }

    public static byte totalMktKnockQtyMinValue()
    {
        return (byte)32;
    }

    public static byte totalMktKnockQtyMaxValue()
    {
        return (byte)126;
    }

    public static int totalMktKnockQtyLength()
    {
        return 23;
    }

    public void totalMktKnockQty(final int index, final byte value)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 243 + (index * 1);
        buffer.putByte(pos, value);
    }

    public static String totalMktKnockQtyCharacterEncoding()
    {
        return "ASCII";
    }

    public SyncMessageEncoder putTotalMktKnockQty(final byte[] src, final int srcOffset)
    {
        final int length = 23;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        buffer.putBytes(this.offset + 243, src, srcOffset, length);

        return this;
    }

    public SyncMessageEncoder totalMktKnockQty(final String src)
    {
        final int length = 23;
        final byte[] bytes = src.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        if (bytes.length > length)
        {
            throw new IndexOutOfBoundsException("String too large for copy: byte length=" + bytes.length);
        }

        buffer.putBytes(this.offset + 243, bytes, 0, bytes.length);

        for (int start = bytes.length; start < length; ++start)
        {
            buffer.putByte(this.offset + 243 + start, (byte)0);
        }

        return this;
    }


    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        SyncMessageDecoder writer = new SyncMessageDecoder();
        writer.wrap(buffer, offset, BLOCK_LENGTH, SCHEMA_VERSION);

        return writer.appendTo(builder);
    }
}
