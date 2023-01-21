package org.gxj.demo.jvm.instructions.stack.dup;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;
import org.gxj.demo.jvm.rtda.Slot;

/**
 * @author gxj
 * @date 2023/1/15 22:05
 */
public class DUP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Slot slot = stack.popSlot();
        stack.pushSlot(slot);
        stack.pushSlot(slot);
    }
}
