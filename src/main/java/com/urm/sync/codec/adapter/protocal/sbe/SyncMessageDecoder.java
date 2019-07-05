/* Generated SBE (Simple Binary Encoding) message codec */
package com.urm.sync.codec.adapter.protocal.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

@javax.annotation.Generated(value = {"com.urm.sync.codec.adapter.protocal.sbe.SyncMessageDecoder"})
@SuppressWarnings("all")
public class SyncMessageDecoder
{
    public static final int BLOCK_LENGTH = 266;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;

    private final SyncMessageDecoder parentMessage = this;
    private DirectBuffer buffer;
    protected int offset;
    protected int limit;
    protected int actingBlockLength;
    protected int actingVersion;

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

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public SyncMessageDecoder wrap(
        final DirectBuffer buffer, final int offset, final int actingBlockLength, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

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

    public static int idId()
    {
        return 1;
    }

    public static int idSinceVersion()
    {
        return 0;
    }

    public static int idEncodingOffset()
    {
        return 0;
    }

    public static int idEncodingLength()
    {
        return 32;
    }

    public static String idMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte id(final int index)
    {
        if (index < 0 || index >= 32)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 0 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String idCharacterEncoding()
    {
        return "ASCII";
    }

    public int getId(final byte[] dst, final int dstOffset)
    {
        final int length = 32;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 0, dst, dstOffset, length);

        return length;
    }

    public String id()
    {
        final byte[] dst = new byte[32];
        buffer.getBytes(this.offset + 0, dst, 0, 32);

        int end = 0;
        for (; end < 32 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int sequenceIdId()
    {
        return 2;
    }

    public static int sequenceIdSinceVersion()
    {
        return 0;
    }

    public static int sequenceIdEncodingOffset()
    {
        return 32;
    }

    public static int sequenceIdEncodingLength()
    {
        return 32;
    }

    public static String sequenceIdMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte sequenceId(final int index)
    {
        if (index < 0 || index >= 32)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 32 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String sequenceIdCharacterEncoding()
    {
        return "ASCII";
    }

    public int getSequenceId(final byte[] dst, final int dstOffset)
    {
        final int length = 32;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 32, dst, dstOffset, length);

        return length;
    }

    public String sequenceId()
    {
        final byte[] dst = new byte[32];
        buffer.getBytes(this.offset + 32, dst, 0, 32);

        int end = 0;
        for (; end < 32 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int timestampId()
    {
        return 3;
    }

    public static int timestampSinceVersion()
    {
        return 0;
    }

    public static int timestampEncodingOffset()
    {
        return 64;
    }

    public static int timestampEncodingLength()
    {
        return 23;
    }

    public static String timestampMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte timestamp(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 64 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String timestampCharacterEncoding()
    {
        return "ASCII";
    }

    public int getTimestamp(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 64, dst, dstOffset, length);

        return length;
    }

    public String timestamp()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(this.offset + 64, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int exchIdId()
    {
        return 4;
    }

    public static int exchIdSinceVersion()
    {
        return 0;
    }

    public static int exchIdEncodingOffset()
    {
        return 87;
    }

    public static int exchIdEncodingLength()
    {
        return 6;
    }

    public static String exchIdMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte exchId(final int index)
    {
        if (index < 0 || index >= 6)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 87 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String exchIdCharacterEncoding()
    {
        return "ASCII";
    }

    public int getExchId(final byte[] dst, final int dstOffset)
    {
        final int length = 6;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 87, dst, dstOffset, length);

        return length;
    }

    public String exchId()
    {
        final byte[] dst = new byte[6];
        buffer.getBytes(this.offset + 87, dst, 0, 6);

        int end = 0;
        for (; end < 6 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int stkIdId()
    {
        return 5;
    }

    public static int stkIdSinceVersion()
    {
        return 0;
    }

    public static int stkIdEncodingOffset()
    {
        return 93;
    }

    public static int stkIdEncodingLength()
    {
        return 35;
    }

    public static String stkIdMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte stkId(final int index)
    {
        if (index < 0 || index >= 35)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 93 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String stkIdCharacterEncoding()
    {
        return "ASCII";
    }

    public int getStkId(final byte[] dst, final int dstOffset)
    {
        final int length = 35;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 93, dst, dstOffset, length);

        return length;
    }

    public String stkId()
    {
        final byte[] dst = new byte[35];
        buffer.getBytes(this.offset + 93, dst, 0, 35);

        int end = 0;
        for (; end < 35 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int closePriceId()
    {
        return 6;
    }

    public static int closePriceSinceVersion()
    {
        return 0;
    }

    public static int closePriceEncodingOffset()
    {
        return 128;
    }

    public static int closePriceEncodingLength()
    {
        return 23;
    }

    public static String closePriceMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte closePrice(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 128 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String closePriceCharacterEncoding()
    {
        return "ASCII";
    }

    public int getClosePrice(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 128, dst, dstOffset, length);

        return length;
    }

    public String closePrice()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(this.offset + 128, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int newPriceId()
    {
        return 7;
    }

    public static int newPriceSinceVersion()
    {
        return 0;
    }

    public static int newPriceEncodingOffset()
    {
        return 151;
    }

    public static int newPriceEncodingLength()
    {
        return 23;
    }

    public static String newPriceMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte newPrice(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 151 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String newPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public int getNewPrice(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 151, dst, dstOffset, length);

        return length;
    }

    public String newPrice()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(this.offset + 151, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int maxOrderPriceId()
    {
        return 8;
    }

    public static int maxOrderPriceSinceVersion()
    {
        return 0;
    }

    public static int maxOrderPriceEncodingOffset()
    {
        return 174;
    }

    public static int maxOrderPriceEncodingLength()
    {
        return 23;
    }

    public static String maxOrderPriceMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte maxOrderPrice(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 174 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String maxOrderPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public int getMaxOrderPrice(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 174, dst, dstOffset, length);

        return length;
    }

    public String maxOrderPrice()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(this.offset + 174, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int minOrderPriceId()
    {
        return 9;
    }

    public static int minOrderPriceSinceVersion()
    {
        return 0;
    }

    public static int minOrderPriceEncodingOffset()
    {
        return 197;
    }

    public static int minOrderPriceEncodingLength()
    {
        return 23;
    }

    public static String minOrderPriceMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte minOrderPrice(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 197 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String minOrderPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public int getMinOrderPrice(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 197, dst, dstOffset, length);

        return length;
    }

    public String minOrderPrice()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(this.offset + 197, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int knockAvgPriceId()
    {
        return 10;
    }

    public static int knockAvgPriceSinceVersion()
    {
        return 0;
    }

    public static int knockAvgPriceEncodingOffset()
    {
        return 220;
    }

    public static int knockAvgPriceEncodingLength()
    {
        return 23;
    }

    public static String knockAvgPriceMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte knockAvgPrice(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 220 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String knockAvgPriceCharacterEncoding()
    {
        return "ASCII";
    }

    public int getKnockAvgPrice(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 220, dst, dstOffset, length);

        return length;
    }

    public String knockAvgPrice()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(this.offset + 220, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }


    public static int totalMktKnockQtyId()
    {
        return 11;
    }

    public static int totalMktKnockQtySinceVersion()
    {
        return 0;
    }

    public static int totalMktKnockQtyEncodingOffset()
    {
        return 243;
    }

    public static int totalMktKnockQtyEncodingLength()
    {
        return 23;
    }

    public static String totalMktKnockQtyMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
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

    public byte totalMktKnockQty(final int index)
    {
        if (index < 0 || index >= 23)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        final int pos = this.offset + 243 + (index * 1);

        return buffer.getByte(pos);
    }


    public static String totalMktKnockQtyCharacterEncoding()
    {
        return "ASCII";
    }

    public int getTotalMktKnockQty(final byte[] dst, final int dstOffset)
    {
        final int length = 23;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        buffer.getBytes(this.offset + 243, dst, dstOffset, length);

        return length;
    }

    public String totalMktKnockQty()
    {
        final byte[] dst = new byte[23];
        buffer.getBytes(this.offset + 243, dst, 0, 23);

        int end = 0;
        for (; end < 23 && dst[end] != 0; ++end);

        return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
    }



    public String toString()
    {
        return appendTo(new StringBuilder(100)).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        final int originalLimit = limit();
        limit(offset + actingBlockLength);
        builder.append("[SyncMessage](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        //Token{signal=BEGIN_FIELD, name='id', description='null', id=1, version=0, encodedLength=0, offset=0, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char32', description='null', id=-1, version=0, encodedLength=32, offset=0, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("id=");
        for (int i = 0; i < idLength() && id(i) > 0; i++)
        {
            builder.append((char)id(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='sequenceId', description='null', id=2, version=0, encodedLength=0, offset=32, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char32', description='null', id=-1, version=0, encodedLength=32, offset=32, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("sequenceId=");
        for (int i = 0; i < sequenceIdLength() && sequenceId(i) > 0; i++)
        {
            builder.append((char)sequenceId(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='timestamp', description='null', id=3, version=0, encodedLength=0, offset=64, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char23', description='null', id=-1, version=0, encodedLength=23, offset=64, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("timestamp=");
        for (int i = 0; i < timestampLength() && timestamp(i) > 0; i++)
        {
            builder.append((char)timestamp(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='exchId', description='null', id=4, version=0, encodedLength=0, offset=87, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char6', description='null', id=-1, version=0, encodedLength=6, offset=87, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("exchId=");
        for (int i = 0; i < exchIdLength() && exchId(i) > 0; i++)
        {
            builder.append((char)exchId(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='stkId', description='null', id=5, version=0, encodedLength=0, offset=93, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char35', description='null', id=-1, version=0, encodedLength=35, offset=93, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("stkId=");
        for (int i = 0; i < stkIdLength() && stkId(i) > 0; i++)
        {
            builder.append((char)stkId(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='closePrice', description='null', id=6, version=0, encodedLength=0, offset=128, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char23', description='null', id=-1, version=0, encodedLength=23, offset=128, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("closePrice=");
        for (int i = 0; i < closePriceLength() && closePrice(i) > 0; i++)
        {
            builder.append((char)closePrice(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='newPrice', description='null', id=7, version=0, encodedLength=0, offset=151, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char23', description='null', id=-1, version=0, encodedLength=23, offset=151, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("newPrice=");
        for (int i = 0; i < newPriceLength() && newPrice(i) > 0; i++)
        {
            builder.append((char)newPrice(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='maxOrderPrice', description='null', id=8, version=0, encodedLength=0, offset=174, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char23', description='null', id=-1, version=0, encodedLength=23, offset=174, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("maxOrderPrice=");
        for (int i = 0; i < maxOrderPriceLength() && maxOrderPrice(i) > 0; i++)
        {
            builder.append((char)maxOrderPrice(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='minOrderPrice', description='null', id=9, version=0, encodedLength=0, offset=197, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char23', description='null', id=-1, version=0, encodedLength=23, offset=197, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("minOrderPrice=");
        for (int i = 0; i < minOrderPriceLength() && minOrderPrice(i) > 0; i++)
        {
            builder.append((char)minOrderPrice(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='knockAvgPrice', description='null', id=10, version=0, encodedLength=0, offset=220, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char23', description='null', id=-1, version=0, encodedLength=23, offset=220, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("knockAvgPrice=");
        for (int i = 0; i < knockAvgPriceLength() && knockAvgPrice(i) > 0; i++)
        {
            builder.append((char)knockAvgPrice(i));
        }
        builder.append('|');
        //Token{signal=BEGIN_FIELD, name='totalMktKnockQty', description='null', id=11, version=0, encodedLength=0, offset=243, componentTokenCount=3, encoding=Encoding{presence=REQUIRED, primitiveType=null, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='null', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        //Token{signal=ENCODING, name='char23', description='null', id=-1, version=0, encodedLength=23, offset=243, componentTokenCount=1, encoding=Encoding{presence=REQUIRED, primitiveType=CHAR, byteOrder=LITTLE_ENDIAN, minValue=null, maxValue=null, nullValue=null, constValue=null, characterEncoding='ASCII', epoch='unix', timeUnit=nanosecond, semanticType='null'}}
        builder.append("totalMktKnockQty=");
        for (int i = 0; i < totalMktKnockQtyLength() && totalMktKnockQty(i) > 0; i++)
        {
            builder.append((char)totalMktKnockQty(i));
        }

        limit(originalLimit);

        return builder;
    }
}
