package org.gxj.demo.jvm.classfile.constantpool.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.constantpool.ConstantInfo;

/**
 * @author gxj
 * @date 2023/1/10 20:54
 */
public class ConstantDoubleInfo implements ConstantInfo {

    private double val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TDouble();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_DOUBLE;
    }

    public double value() {
        return this.val;
    }
}
