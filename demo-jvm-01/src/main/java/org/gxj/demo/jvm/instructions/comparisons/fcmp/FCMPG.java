package org.gxj.demo.jvm.instructions.comparisons.fcmp;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

public class FCMPG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fcmp(frame, true);
    }

}
