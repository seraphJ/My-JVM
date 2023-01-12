package org.gxj.demo.jvm.classfile.attributes.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.attributes.AttributeInfo;
import org.gxj.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @author gxj
 * @date 2023/1/11 22:58
 */
public class SourceFileAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int sourceFileIdx;

    public SourceFileAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.sourceFileIdx = reader.readUint16();
    }

    public String fileName() {
        return this.constantPool.getUTF8(this.sourceFileIdx);
    }
}
