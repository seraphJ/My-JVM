package org.gxj.demo.jvm.classfile.constantpool.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * @author gxj
 * @date 2023/1/10 21:10
 */
public class ConstantFloatInfo implements ConstantInfo {

    private float val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TFloat();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }

    public float value() {
        return this.val;
    }
}
