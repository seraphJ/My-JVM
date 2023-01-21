package org.gxj.demo.jvm.instructions.control;

import org.gxj.demo.jvm.instructions.base.BytecodeReader;
import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/20 22:16
 */
public class LOOKUP_SWITCH implements Instruction {

    private int defaultOffset;
    private int npairs;
    private int[] matchOffsets;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        this.defaultOffset = reader.readInt();
        this.npairs = reader.readInt();
        this.matchOffsets = reader.readInts(this.npairs * 2);
    }

    @Override
    public void execute(Frame frame) {
        //TODO 测试
        int key = frame.operandStack().popInt();
        for (int i = 0; i < this.npairs * 2; i += 2) {
            if (this.matchOffsets[i] == key) {
                int offset = this.matchOffsets[i + 1];
                Instruction.branch(frame, offset);
                return;
            }
        }
        Instruction.branch(frame, this.defaultOffset);
    }
}
