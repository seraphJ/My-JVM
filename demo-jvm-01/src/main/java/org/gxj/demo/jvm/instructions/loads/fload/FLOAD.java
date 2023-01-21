package org.gxj.demo.jvm.instructions.loads.fload;

import org.gxj.demo.jvm.instructions.base.InstructionIndex8;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:32
 */
public class FLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        float val = frame.localVars().getFloat(this.idx);
        frame.operandStack().pushFloat(val);
    }
}
