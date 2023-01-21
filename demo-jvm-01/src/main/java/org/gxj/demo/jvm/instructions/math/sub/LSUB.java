package org.gxj.demo.jvm.instructions.math.sub;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/15 22:21
 */
public class LSUB extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        long res = v2 - v1;
        stack.pushLong(res);
    }
}
