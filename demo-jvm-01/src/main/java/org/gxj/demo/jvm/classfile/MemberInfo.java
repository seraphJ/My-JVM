package org.gxj.demo.jvm.classfile;

import org.gxj.demo.jvm.classfile.attributes.AttributeInfo;
import org.gxj.demo.jvm.classfile.attributes.impl.CodeAttribute;
import org.gxj.demo.jvm.classfile.attributes.impl.ConstantValueAttribute;
import org.gxj.demo.jvm.classfile.constantpool.ConstantPool;

/**
 * @author gxj
 * @date 2023/1/10 17:33
 */
public class MemberInfo {

    private ConstantPool constantPool;
    private int accessFlags;
    private int nameIdx;
    private int descriptorIdx;
    private AttributeInfo[] attributes;

    private MemberInfo(ClassReader reader, ConstantPool constantPool) {
        this.constantPool = constantPool;
        this.accessFlags = reader.readUint16();
        this.nameIdx = reader.readUint16();
        this.descriptorIdx = reader.readUint16();
        this.attributes = AttributeInfo.readAttributes(reader, constantPool);
    }

    static MemberInfo[] readMembers(ClassReader reader, ConstantPool constantPool) {
        int fieldCount = reader.readUint16();
        MemberInfo[] fields = new MemberInfo[fieldCount];
        for (int i = 0; i < fieldCount; i++) {
            fields[i] = new MemberInfo(reader, constantPool);
        }
        return fields;
    }

    public int accessFlags() {
        return this.accessFlags;
    }

    public String name() {
        return this.constantPool.getUTF8(this.nameIdx);
    }

    public String descriptor() {
        return this.constantPool.getUTF8(this.descriptorIdx);
    }

    public CodeAttribute codeAttribute() {
        for (AttributeInfo attrInfo : attributes) {
            if (attrInfo instanceof CodeAttribute) {
                return (CodeAttribute) attrInfo;
            }
        }
        return null;
    }

    public ConstantValueAttribute constantValueAttribute() {
        for (AttributeInfo attrInfo : attributes) {
            if (attrInfo instanceof ConstantValueAttribute) {
                return (ConstantValueAttribute) attrInfo;
            }
        }
        return null;
    }
}
