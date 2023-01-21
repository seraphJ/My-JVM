package org.gxj.demo.test;

/**
 * @author gxj
 * @date 2022/12/26 15:36
 */

public class HelloWorld {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}