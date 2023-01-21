package org.gxj.demo.jvm.instructions.math.sh;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.OperandStack;

/**
 * @author gxj
 * @date 2023/1/16 22:31
 */
public class LSHL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        int s = v2 & 0x3f;
        long res = v1 << s;
        stack.pushLong(res);
    }
}
