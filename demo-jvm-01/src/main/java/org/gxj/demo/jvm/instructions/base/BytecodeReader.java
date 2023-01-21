package org.gxj.demo.jvm.instructions.base;

/**
 * @author gxj
 * @date 2023/1/14 21:23
 */
public class BytecodeReader {

    private byte[] codes;
    private int pc;

    public void reset(byte[] codes, int pc) {
        this.codes = codes;
        this.pc = pc;
    }

    public int pc() {
        return this.pc;
    }

    public byte readByte() {
        byte code = this.codes[this.pc];
        this.pc++;
        return code;
    }

    public short readShort() {
        byte byte1 = readByte();
        byte byte2 = readByte();
        return (short) ((byte1 << 8) | byte2);
    }

    public int readInt() {
        byte byte1 = readByte();
        byte byte2 = readByte();
        byte byte3 = readByte();
        byte byte4 = readByte();
        return (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4;
    }

    //used by lookupswitch and tableswitch
    public int[] readInts(int n) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = this.readInt();
        }
        return ints;
    }

    //used by lookupswitch and tableswitch
    public void skipPadding() {
        while (this.pc % 4 != 0) {
            this.readByte();
        }
    }
}
