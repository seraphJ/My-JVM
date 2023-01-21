package org.gxj.demo.jvm.instructions.stack.pop;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/15 22:03
 */
public class POP2 extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        stack.popSlot();
        stack.popSlot();
    }
}
