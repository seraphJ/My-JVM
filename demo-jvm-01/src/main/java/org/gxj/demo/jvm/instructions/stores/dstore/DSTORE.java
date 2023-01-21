package org.gxj.demo.jvm.instructions.stores.dstore;

import org.gxj.demo.jvm.instructions.base.InstructionIndex8;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:47
 * store reference into local variable
 */
public class DSTORE extends InstructionIndex8 {
    @Override
    public void execute(Frame frame) {
        _dstore(frame, this.idx);
    }
}