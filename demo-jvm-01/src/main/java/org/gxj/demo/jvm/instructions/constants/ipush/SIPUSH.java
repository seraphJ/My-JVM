package org.gxj.demo.jvm.instructions.constants.ipush;

import org.gxj.demo.jvm.instructions.base.BytecodeReader;
import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:17
 */
public class SIPUSH implements Instruction {

    private short val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(val);
    }
}
