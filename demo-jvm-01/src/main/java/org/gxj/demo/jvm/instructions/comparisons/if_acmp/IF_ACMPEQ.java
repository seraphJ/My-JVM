package org.gxj.demo.jvm.instructions.comparisons.if_acmp;

import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.instructions.base.InstructionBranch;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/18 22:40
 */
public class IF_ACMPEQ extends InstructionBranch {
    @Override
    public void execute(Frame frame) {
        if (_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }
}
