package org.gxj.demo.jvm.instructions.stores.istore;

import org.gxj.demo.jvm.instructions.base.InstructionIndex8;
import org.gxj.demo.jvm.instructions.base.InstructionNoOperands;
import org.gxj.demo.jvm.rtda.Frame;

/**
 * @author gxj
 * @date 2023/1/14 22:47
 * store reference into local variable
 */
public class ISTORE_0 extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        _istore(frame, 0);
    }
}
