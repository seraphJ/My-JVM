package org.gxj.demo.jvm.classfile.constantpool.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.constantpool.ConstantInfo;
import org.gxj.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @author gxj
 * @date 2023/1/10 20:54
 */
public class ConstantStringInfo implements ConstantInfo {

    private ConstantPool constantPool;
    private int strIdx;

    public ConstantStringInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.strIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_STRING;
    }

    public String string() {
        return this.constantPool.getUTF8(this.strIdx);
    }
}
