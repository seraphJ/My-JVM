package org.gxj.demo.jvm.instructions.conversions.i2x;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/17 22:36
 */
public class I2B extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        int b = (byte) i;
        stack.pushInt(b);
    }

}
