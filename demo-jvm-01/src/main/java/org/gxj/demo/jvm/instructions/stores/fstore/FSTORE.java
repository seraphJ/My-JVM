package org.gxj.demo.jvm.instructions.stores.fstore;

import org.gxj.demo.jvm.instructions.base.InstructionIndex8;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:47
 * store reference into local variable
 */
public class FSTORE extends InstructionIndex8 {
    @Override
    public void execute(Frame frame) {
        _fstore(frame, this.idx);
    }
}
