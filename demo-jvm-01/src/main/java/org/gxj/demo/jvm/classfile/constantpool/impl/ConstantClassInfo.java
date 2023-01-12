package org.gxj.demo.jvm.classfile.constantpool.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.constantpool.ConstantInfo;
import org.gxj.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @author gxj
 * @date 2023/1/10 20:54
 */
public class ConstantClassInfo implements ConstantInfo {

    public ConstantPool constantPool;
    public int nameIdx;

    public ConstantClassInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_CLASS;
    }

    public String name() {
        return this.constantPool.getUTF8(this.nameIdx);
    }
}
