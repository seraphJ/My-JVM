package org.gxj.demo.jvm.instructions.math.iinc;

import org.gxj.demo.jvm.instructions.base.BytecodeReader;
import org.gxj.demo.jvm.instructions.base.Instruction;
import org.gxj.demo.jvm.rtda.Frame;
import org.gxj.demo.jvm.rtda.LocalVars;

/**
 * @author gxj
 * @date 2023/1/17 22:23
 */
public class IINC implements Instruction {

    public int idx;
    public int constVal;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readByte();
        this.constVal = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        LocalVars vars = frame.localVars();
        int val = vars.getInt(this.idx);
        val += this.constVal;
        vars.setInt(this.idx, val);
    }
}
