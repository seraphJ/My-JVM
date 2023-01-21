package org.gxj.demo.jvm.instructions.loads.iload;

import org.gxj.demo.jvm.instructions.base.InstructionIndex8;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:23
 */
public class ILOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(this.idx);
        frame.operandStack().pushInt(val);
    }
}
