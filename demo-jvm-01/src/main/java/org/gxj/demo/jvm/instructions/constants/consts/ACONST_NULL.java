package org.gxj.demo.jvm.instructions.constants.consts;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 21:38
 */
public class ACONST_NULL extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushRef(null);
    }
}
