package com.ty.algorithm.test;

import com.ty.algorithm.sort.Selection;

import java.util.Arrays;

/**
 * @author tanyun
 * @description
 * @date 2021/7/14 22:23
 */
public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,1};
        Selection.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
