package org.gxj.demo.jvm.classfile.attributes.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.attributes.AttributeInfo;
import org.gxj.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @author gxj
 * @date 2023/1/11 23:11
 */
public class CodeAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int maxStack;
    private int maxLocals;
    private byte[] data;
    private ExceptionTableEntry[] exceptionTable;
    private AttributeInfo[] attributes;

    public CodeAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.maxStack = reader.readUint16();
        this.maxLocals = reader.readUint16();
        int dataLength = (int) reader.readUint32();
        this.data = reader.readBytes(dataLength);
        this.exceptionTable = ExceptionTableEntry.readExceptionTable(reader);
        this.attributes = AttributeInfo.readAttributes(reader, this.constantPool);
    }

    public int maxStack() {
        return maxStack;
    }

    public int maxLocals() {
        return maxLocals;
    }

    public byte[] data() {
        return data;
    }

    public ExceptionTableEntry[] exceptionTable() {
        return exceptionTable;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    static class ExceptionTableEntry {

        private int startPC;
        private int endPC;
        private int handlerPC;
        private int catchType;

        public ExceptionTableEntry(int startPC, int endPC, int handlerPC, int catchType) {
            this.startPC = startPC;
            this.endPC = endPC;
            this.handlerPC = handlerPC;
            this.catchType = catchType;
        }

        static ExceptionTableEntry[] readExceptionTable(ClassReader reader) {
            int exceptionTableLength = reader.readUint16();
            ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[exceptionTableLength];
            for (int i = 0; i < exceptionTableLength; i++) {
                exceptionTable[i] = new ExceptionTableEntry(reader.readUint16(), reader.readUint16(), reader.readUint16(), reader.readUint16());
            }
            return exceptionTable;
        }

        public int startPC() {
            return startPC;
        }

        public int endPC() {
            return endPC;
        }

        public int handlerPC() {
            return handlerPC;
        }

        public int catchType() {
            return catchType;
        }
    }
}
