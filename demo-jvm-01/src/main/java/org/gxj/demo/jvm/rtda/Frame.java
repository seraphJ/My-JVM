package org.gxj.demo.jvm.rtda;

/**
 * @author gxj
 * @date 2023/1/14 15:44
 * 栈帧
 */
public class Frame {

    //stack is implemented as linked list
    Frame lower;

    //局部变量表
    private LocalVars localVars;

    //操作数栈
    private OperandStack operandStack;

    private Thread thread;

    private int nextPC;

    public Frame(Thread thread, int maxLocals, int maxStack) {
        this.thread = thread;
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars localVars() {
        return this.localVars;
    }

    public OperandStack operandStack() {
        return this.operandStack;
    }

    public Thread thread() {
        return this.thread;
    }

    public int nextPC() {
        return this.nextPC;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }
}
