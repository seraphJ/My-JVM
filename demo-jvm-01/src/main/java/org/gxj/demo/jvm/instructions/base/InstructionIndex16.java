package org.gxj.demo.jvm.instructions.base;

import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 21:13
 */
public class InstructionIndex16 implements Instruction {

    protected int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }
}
