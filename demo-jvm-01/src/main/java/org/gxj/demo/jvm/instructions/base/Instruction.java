package org.gxj.demo.jvm.instructions.base;

import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 20:55
 */
public interface Instruction {

    void fetchOperands(BytecodeReader reader);

    void execute(Frame frame);

    static void branch(Frame frame, int offset) {
        int pc = frame.thread().pc();
        int nextPC = pc + offset;
        frame.setNextPC(nextPC);
    }
}
