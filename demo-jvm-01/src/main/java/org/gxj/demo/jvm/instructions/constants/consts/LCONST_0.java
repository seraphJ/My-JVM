package org.gxj.demo.jvm.instructions.constants.consts;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 21:49
 */
public class LCONST_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushLong(0);
    }
}
