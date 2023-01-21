package org.gxj.demo.jvm.instructions.conversions.l2x;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

//convert long to float
public class L2F extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long l = stack.popLong();
        float f = l;
        stack.pushFloat(f);
    }

}
