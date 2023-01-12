package org.gxj.demo.jvm.classfile.constantpool;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.constantpool.impl.ConstantClassInfo;
import org.gxj.demo.jvm.classfile.constantpool.impl.ConstantNameAndTypeInfo;
import org.gxj.demo.jvm.classfile.constantpool.impl.ConstantUtf8Info;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gxj
 * @date 2023/1/10 17:30
 */
public class ConstantPool {

    private ConstantInfo[] constantInfos;
    private final int size;

    public ConstantPool(ClassReader reader) {
        this.size = reader.readUint16();
        this.constantInfos = new ConstantInfo[size];
        for (int i = 1; i < size; i++) {

            constantInfos[i] = ConstantInfo.readConstantInfo(reader, this);

            switch (constantInfos[i].tag()) {
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                case ConstantInfo.CONSTANT_TAG_LONG:
                    i++;
                    break;
            }
        }
    }

    public Map<String, String> getNameAndType(int idx) {
        ConstantNameAndTypeInfo constantInfo = (ConstantNameAndTypeInfo) this.constantInfos[idx];
        Map<String, String> map = new HashMap<>();
        map.put("name", this.getUTF8(constantInfo.nameIdx));
        map.put("_type", this.getUTF8(constantInfo.descIdx));
        return map;
    }

    public String getClassName(int idx) {
        ConstantClassInfo classInfo = (ConstantClassInfo) this.constantInfos[idx];
        return this.getUTF8(classInfo.nameIdx);
    }

    public String getUTF8(int idx) {
        ConstantUtf8Info utf8Info = (ConstantUtf8Info) this.constantInfos[idx];
        return utf8Info == null ? "" : utf8Info.str();
    }

    public ConstantInfo[] getConstantInfos() {
        return this.constantInfos;
    }

    public void setConstantInfos(ConstantInfo[] constantInfos) {
        this.constantInfos = constantInfos;
    }

    public int getSize() {
        return this.size;
    }
}
