package com.ty.algorithm.test;

import com.ty.algorithm.sort.Merge;

import java.util.Arrays;

/**
 * @author tanyun
 * @description
 * @date 2021/7/19 22:18
 */
public class MergeTest {

    public static void main(String[] args) {
        Integer[] arr = {8,4,5,7,1,3,6,2};
        Merge.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
