package org.gxj.demo.jvm.instructions.loads.lload;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:23
 */
public class LLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        long val = frame.localVars().getLong(2);
        frame.operandStack().pushLong(val);
    }
}
