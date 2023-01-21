package org.gxj.demo.jvm.instructions.comparisons.if_icmp;

import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.instructions.base.InstructionBranch;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

public class IF_ICMPGT extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if (val1 > val2) {
            Instruction.branch(frame, this.offset);
        }
    }

}