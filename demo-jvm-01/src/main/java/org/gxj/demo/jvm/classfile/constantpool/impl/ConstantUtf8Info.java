package org.gxj.demo.jvm.classfile.constantpool.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * @author gxj
 * @date 2023/1/10 20:54
 */
public class ConstantUtf8Info implements ConstantInfo {

    private String str;

    @Override
    public void readInfo(ClassReader reader) {
        int length = reader.readUint16();
        byte[] bytes = reader.readBytes(length);
        this.str = new String(bytes);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_UTF8;
    }

    public String str() {
        return this.str;
    }
}
