package org.gxj.demo.jvm.instructions.math.rem;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/15 22:21
 */
public class LREM extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        if (v1 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        long res = v2 % v1;
        stack.pushLong(res);
    }
}
