package org.gxj.demo.test;

/**
 * @author gxj
 * @date 2022/12/26 15:36
 */

import java.math.BigInteger;

/**
 * byte 取值范围
 * +127 = [0][1][1][1][1][1][1][1]
 * -128 = [1][0][0][0][0][0][0][0]
 *
 * 有符号
 * -120 = [1][1][1][1][1][0][0][0]
 * 无符号（增位） 136 = 256 - 120
 * 136 = [0][0][0][0][0][0][0][0][1][0][0][0][1][0][0][0]
 *
 * 输出二进制：new BigInteger("-120", 10).toString(2))
 */
public class HelloWorld {
    public static void main(String[] args) {
        float val = 0.1f;
        int num = Float.floatToIntBits(val);
        float val1 = Float.intBitsToFloat(num);
        System.out.println(val);
        System.out.println(val1);
    }

}