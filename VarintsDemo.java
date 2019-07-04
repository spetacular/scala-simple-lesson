import java.nio.ByteBuffer;

public class VarintsDemo{
    private final byte x00 = 0x00;
    private final byte x01 = 0x01;
    private final byte x02 = 0x02;
    private final byte x0a = 0x0a;
    private final byte x0F = 0x0f;
    private final byte x7E = 0x7E;
    private final byte x7F = 0x7F;
    private final byte xFF = (byte) 0xff;
    private final byte x80 = (byte) 0x80;
    private final byte x81 = (byte) 0x81;
    private final byte xFE = (byte) 0xfe;


    public static void main(String[] args){
        int in = 300;
        VarintsDemo v = new VarintsDemo();
        ByteBuffer buf_in = ByteBuffer.allocate(v.sizeOfVarint(in));
        v.writeVarint(in, buf_in);
        for (byte b : buf_in.array()) {
            System.out.print(b);
        }
        System.out.println();
        buf_in.rewind();
        int out = v.readVarint(buf_in);
        System.out.println(out);


        ByteBuffer buf_out = ByteBuffer.wrap(new byte[] { v.x0a});
        
        int i = v.readVarint(buf_out);
        System.out.println(i);
    }

    public int sizeOfVarint(int value) {
        int v = (value << 1) ^ (value >> 31);
        int bytes = 1;
        while ((v & 0xffffff80) != 0L) {
            bytes += 1;
            v >>>= 7;
        }
        return bytes;
    }

    public int readVarint(ByteBuffer buffer) {
        int value = 0;
        int i = 0;
        int b;
        //System.out.println("Buf="+buffer);
        while (((b = buffer.get()) & 0x80) != 0) {
            System.out.println("BB="+b);
            value |= (b & 0x7f) << i;
            i += 7;
            if (i > 28)
                throw illegalVarintException(value);
        }
        value |= b << i;
        return (value >>> 1) ^ -(value & 1);
    }

    /**
     * Write the given integer following the variable-length zig-zag encoding from
     * <a href="http://code.google.com/apis/protocolbuffers/docs/encoding.html"> Google Protocol Buffers</a>
     * into the buffer.
     *
     * @param value The value to write
     * @param buffer The output to write to
     */
    public void writeVarint(int value, ByteBuffer buffer) {
        int v = (value << 1) ^ (value >> 31);
        //System.out.println(v);
        while ((v & 0xffffff80) != 0L) {
            byte b = (byte) ((v & 0x7f) | 0x80);
            buffer.put(b);
            v >>>= 7;
        }
        //System.out.println(v);
        buffer.put((byte) v);
    }

    private static IllegalArgumentException illegalVarintException(int value) {
        throw new IllegalArgumentException("Varint is too long, the most significant bit in the 5th byte is set, " +
                "converted value: " + Integer.toHexString(value));
    }
}
