package org.gxj.demo.jvm.instructions.control;

import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.instructions.base.InstructionBranch;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/20 20:48
 */
public class GOTO extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame, this.offset);
    }
}
