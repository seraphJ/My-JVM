package org.gxj.demo.jvm.instructions.stores.lstore;

import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:47
 * store reference into local variable
 */
public class LSTORE_2 extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        _lstore(frame, 2);
    }
}
