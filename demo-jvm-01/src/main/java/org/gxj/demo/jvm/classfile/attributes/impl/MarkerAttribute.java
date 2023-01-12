package org.gxj.demo.jvm.classfile.attributes.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.attributes.AttributeInfo;

/**
 * @author gxj
 * @date 2023/1/11 22:53
 */
public class MarkerAttribute implements AttributeInfo {
    @Override
    public void readInfo(ClassReader reader) {
        // read nothing
    }
}
