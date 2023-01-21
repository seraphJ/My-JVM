package org.gxj.demo.jvm.rtda;

/**
 * @author gxj
 * @date 2023/1/14 16:19
 * 操作数栈
 */
public class OperandStack {

    private int size = 0;
    private Slot[] slots;

    public OperandStack(int maxStack) {
        if (maxStack > 0) {
            slots = new Slot[maxStack];
            for (int i = 0; i < maxStack; i++) {
                slots[i] = new Slot();
            }
        }
    }

    public void pushInt(int val) {
        slots[size].num = val;
        size++;
    }

    public int popInt() {
        size--;
        return slots[size].num;
    }

    public void pushFloat(float val) {
        slots[size].num = Float.floatToIntBits(val);
        size++;
    }

    public float popFloat() {
        size--;
        return Float.intBitsToFloat(slots[size].num);
    }

    public void pushLong(long val) {
        slots[size].num = (int) val;
        size++;
        slots[size].num = (int) (val >> 32);
        size++;
    }

    public long popLong() {
        size--;
        String high = Integer.toHexString(slots[size].num);
        size--;
        String low = Integer.toHexString(slots[size].num);
        return Long.parseUnsignedLong(high + low, 16);
    }

    public void pushDouble(double val) {
        pushLong(Double.doubleToLongBits(val));
    }

    public double popDouble() {
        return Double.longBitsToDouble(popLong());
    }

    public void pushRef(Object ref) {
        slots[size].ref = ref;
        size++;
    }

    public Object popRef() {
        size--;
        Object ref = slots[size].ref;
        slots[size].ref = null;
        return ref;
    }

    public void pushSlot(Slot slot) {
        slots[size] = slot;
        size++;
    }

    public Slot popSlot() {
        size--;
        return slots[size];
    }

    public Slot[] getSlots() {
        return slots;
    }
}
