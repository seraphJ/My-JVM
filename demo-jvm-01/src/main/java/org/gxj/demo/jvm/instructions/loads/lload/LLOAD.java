package org.gxj.demo.jvm.instructions.loads.lload;

import org.gxj.demo.jvm.instructions.base.InstructionIndex8;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:23
 */
public class LLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        long val = frame.localVars().getLong(this.idx);
        frame.operandStack().pushLong(val);
    }
}
