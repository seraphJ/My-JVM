package org.gxj.demo.jvm.classfile.attributes.impl;

import org.gxj.demo.jvm.classfile.ClassReader;
import org.gxj.demo.jvm.classfile.attributes.AttributeInfo;

/**
 * @author gxj
 * @date 2023/1/11 23:34
 */
public class LineNumberTableAttribute implements AttributeInfo {

    private LineNumberTableEntry[] lineNumberTable;

    @Override
    public void readInfo(ClassReader reader) {
        int lineNumberTableLength = reader.readUint16();
        this.lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i++) {
            lineNumberTable[i] = new LineNumberTableEntry(reader.readUint16(), reader.readUint16());
        }
    }

    public int getLineNumber(int pc) {
        for (int i = this.lineNumberTable.length - 1; i >= 0; i--) {
            LineNumberTableEntry entry = this.lineNumberTable[i];
            if (pc >= entry.startPC) {
                return entry.lineNumber;
            }
        }
        return -1;
    }

    static class LineNumberTableEntry {
        private int startPC;
        private int lineNumber;

        public LineNumberTableEntry(int startPC, int lineNumber) {
            this.startPC = startPC;
            this.lineNumber = lineNumber;
        }
    }
}
