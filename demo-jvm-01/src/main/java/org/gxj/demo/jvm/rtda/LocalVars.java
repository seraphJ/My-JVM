package org.gxj.demo.jvm.rtda;

/**
 * @author gxj
 * @date 2023/1/14 15:45
 */
public class LocalVars {

    private Slot[] slots;

    public LocalVars(int maxLocals) {
        if (maxLocals > 0) {
            slots = new Slot[maxLocals];
            for (int i = 0; i < maxLocals; i++) {
                slots[i] = new Slot();
            }
        }
    }

    public void setInt(int idx, int val) {
        this.slots[idx].num = val;
    }

    public int getInt(int idx) {
        return this.slots[idx].num;
    }

    public void setFloat(int idx, float val) {
        this.slots[idx].num = Float.floatToIntBits(val);
    }

    public Float getFloat(int idx) {
        return Float.intBitsToFloat(this.slots[idx].num);
    }

    public void setLong(int idx, long val) {
        this.slots[idx].num = (int) val;
        this.slots[idx + 1].num = (int) (val >> 32);
    }

    public Long getLong(int idx) {
        String low = Integer.toHexString(this.slots[idx].num);
        String high = Integer.toHexString(this.slots[idx + 1].num);
        return Long.parseUnsignedLong(high + low, 16);
    }

    public void setDouble(int idx, double val) {
        setLong(idx, Double.doubleToLongBits(val));
    }

    public Double getDouble(int idx) {
        return Double.longBitsToDouble(getLong(idx));
    }

    public void setRef(int idx, Object ref) {
        this.slots[idx].ref = ref;
    }

    public Object getRef(int idx) {
        return this.slots[idx].ref;
    }

    public Slot[] getSlots() {
        return slots;
    }
}
