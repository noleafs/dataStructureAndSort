package com.ty.algorithm.test;

import com.ty.algorithm.sort.Shell;

import java.util.Arrays;

/**
 * @author tanyun
 * @description
 * @date 2021/7/16 20:09
 */
public class ShellTest {

    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,14,66,113,4461,1,43,3456,13,1,4651,1,413,4,1,4616,};
        Shell.sort(arr);
        System.out.println(Arrays.asList(arr));
    }

}
