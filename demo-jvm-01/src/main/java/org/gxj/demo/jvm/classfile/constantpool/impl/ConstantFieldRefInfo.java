package org.gxj.demo.jvm.classfile.constantpool.impl;

import org.gxj.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @author gxj
 * @date 2023/1/11 21:10
 */
public class ConstantFieldRefInfo extends ConstantMemberRefInfo {

    public ConstantFieldRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FIELDREF;
    }
}
