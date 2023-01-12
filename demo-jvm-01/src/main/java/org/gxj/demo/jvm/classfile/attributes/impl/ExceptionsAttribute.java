package org.gxj.demo.jvm.classfile.attributes.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.attributes.AttributeInfo;

/**
 * @author gxj
 * @date 2023/1/11 23:28
 */
public class ExceptionsAttribute implements AttributeInfo {

    private int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        this.exceptionIndexTable = reader.readUint16s();
    }

    public int[] exceptionIndexTable() {
        return exceptionIndexTable;
    }
}
