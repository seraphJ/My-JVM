package org.gxj.demo.jvm.instructions.extended.ifnull;

import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.instructions.base.InstructionBranch;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/20 22:40
 */
public class IFNONNULL extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.operandStack().popRef();
        if (null != ref) {
            Instruction.branch(frame, this.offset);
        }
    }
}
