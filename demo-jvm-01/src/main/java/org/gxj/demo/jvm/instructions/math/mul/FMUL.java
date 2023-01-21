package org.gxj.demo.jvm.instructions.math.mul;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/15 22:21
 */
public class FMUL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float v1 = stack.popFloat();
        float v2 = stack.popFloat();
        float res = v1 * v2;
        stack.pushFloat(res);
    }
}
