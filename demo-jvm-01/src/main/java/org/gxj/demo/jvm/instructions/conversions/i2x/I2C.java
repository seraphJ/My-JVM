package org.gxj.demo.jvm.instructions.conversions.i2x;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

//convert int to char
public class I2C extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        int c = (short) i;
        stack.pushInt(c);
    }

}