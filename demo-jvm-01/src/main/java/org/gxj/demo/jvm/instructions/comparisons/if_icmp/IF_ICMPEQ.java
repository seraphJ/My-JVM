package org.gxj.demo.jvm.instructions.comparisons.if_icmp;

import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.instructions.base.InstructionBranch;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/18 22:36
 */
public class IF_ICMPEQ extends InstructionBranch {
    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        if (v1 == v2) {
            Instruction.branch(frame, this.offset);
        }
    }
}
