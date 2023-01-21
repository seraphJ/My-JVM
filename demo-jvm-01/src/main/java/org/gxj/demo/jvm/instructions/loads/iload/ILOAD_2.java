package org.gxj.demo.jvm.instructions.loads.iload;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:23
 */
public class ILOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(2);
        frame.operandStack().pushInt(val);
    }
}
