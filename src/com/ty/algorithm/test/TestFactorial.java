package com.ty.algorithm.test;

/**
 * @author tanyun
 * @description
 * @date 2021/7/16 21:26
 */
public class TestFactorial {

    public static void main(String[] args) {
        long factorial = factorial(15);
        System.out.println(factorial);
    }

    public static long factorial( int n) {
        // 边界条件
        if (n == 1) {
            return 1;
        }

        // 5 * factorial(n-1) * factorial(n-1) * factorial(n-1) * 1
       return n * factorial(n-1);
    }

}
