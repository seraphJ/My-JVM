package org.gxj.demo.jvm.classfile.constantpool.impl;

import org.gxj.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @author gxj
 * @date 2023/1/11 21:10
 */
public class ConstantMethodRefInfo extends ConstantMemberRefInfo {

    public ConstantMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODREF;
    }
}
