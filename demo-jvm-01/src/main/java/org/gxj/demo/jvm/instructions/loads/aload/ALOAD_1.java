package org.gxj.demo.jvm.instructions.loads.aload;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:32
 */
public class ALOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(1);
        frame.operandStack().pushRef(ref);
    }
}
