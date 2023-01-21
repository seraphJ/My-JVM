package org.gxj.demo.jvm.instructions.comparisons.dcmp;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/18 22:19
 */
public class DCMPG extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        _dcmp(frame, true);
    }
}
