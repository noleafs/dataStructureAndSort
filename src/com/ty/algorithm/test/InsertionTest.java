package com.ty.algorithm.test;

import com.ty.algorithm.sort.Insertion;

import java.util.Arrays;

/**
 * @author tanyun
 * @description
 * @date 2021/7/15 21:00
 */
public class InsertionTest {

    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,1};
        Insertion.sort(arr);
        System.out.println(Arrays.asList(arr));
    }

}
