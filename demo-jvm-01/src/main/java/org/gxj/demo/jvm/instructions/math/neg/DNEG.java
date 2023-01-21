package org.gxj.demo.jvm.instructions.math.neg;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/15 22:21
 */
public class DNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double v = stack.popDouble();
        stack.pushDouble(-v);
    }
}
