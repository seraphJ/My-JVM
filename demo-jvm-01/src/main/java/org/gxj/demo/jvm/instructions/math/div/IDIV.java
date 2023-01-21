package org.gxj.demo.jvm.instructions.math.div;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/15 22:21
 */
public class IDIV extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v1 = stack.popInt();
        int v2 = stack.popInt();
        if (v1 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int res = v2 / v1;
        stack.pushInt(res);
    }
}
