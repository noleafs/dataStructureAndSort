package com.ty.algorithm.test;

import com.ty.algorithm.sort.Quick;

import java.util.Arrays;

/**
 * @author tanyun
 * @description
 * @date 2021/7/20 21:49
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {8,4,5,7,1,3,6,2};
        Quick.sort(arr);
        System.out.println("排序后为 "+Arrays.asList(arr));
    }
}
