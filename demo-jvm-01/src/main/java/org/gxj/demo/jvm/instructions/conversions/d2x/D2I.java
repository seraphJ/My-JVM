package org.gxj.demo.jvm.instructions.conversions.d2x;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/17 22:29
 */
public class D2I extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double d = stack.popDouble();
        int i = (int) d;
        stack.pushInt(i);
    }
}
