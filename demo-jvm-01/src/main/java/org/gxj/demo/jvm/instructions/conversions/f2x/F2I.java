package org.gxj.demo.jvm.instructions.conversions.f2x;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/17 22:33
 */
public class F2I extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float f = stack.popFloat();
        int i = (int) f;
        stack.pushInt(i);
    }
}
