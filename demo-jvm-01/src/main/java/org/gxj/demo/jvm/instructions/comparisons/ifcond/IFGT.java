package org.gxj.demo.jvm.instructions.comparisons.ifcond;

import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.instructions.base.InstructionBranch;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/18 22:32
 */
public class IFGT extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (val > 0) {
            Instruction.branch(frame, this.offset);
        }
    }
}
