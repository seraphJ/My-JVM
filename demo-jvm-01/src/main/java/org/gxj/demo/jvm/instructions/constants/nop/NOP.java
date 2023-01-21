package org.gxj.demo.jvm.instructions.constants.nop;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 21:35
 */
public class NOP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        //really do nothing
    }
}
