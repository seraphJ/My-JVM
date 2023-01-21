package org.gxj.demo.jvm.instructions.math.or;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/17 22:18
 */
public class LOR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        long res = v1 | v2;
        stack.pushLong(res);
    }
}
