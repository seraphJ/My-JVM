package org.gxj.demo.jvm.rtda;

/**
 * @author gxj
 * @date 2023/1/14 15:41
 * 线程
 */
public class Thread {

    // Program Counter 寄存器
    private int pc;

    //虚拟机栈
    private JvmStack stack;

    public Thread() {
        this.stack = new JvmStack(1024);
    }

    public int pc() {
        return this.pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void pushFrame(Frame frame) {
        this.stack.push(frame);
    }

    public Frame popFrame() {
        return this.stack.pop();
    }

    public Frame currentFrame() {
        return this.stack.top();
    }

    public Frame newFrame(int maxLocals, int maxStack) {
        return new Frame(this, maxLocals, maxStack);
    }
}
