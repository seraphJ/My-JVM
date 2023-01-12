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

        byte[] val = {-16};

        BigInteger bigInteger = new BigInteger(1, val);

        //无符号（增位）
        String str_hex = bigInteger.toString(10);
        System.out.println(str_hex);
        System.out.println(Integer.parseInt(str_hex, 10));

        //有符号
        System.out.println(bigInteger.byteValue());

    }

}