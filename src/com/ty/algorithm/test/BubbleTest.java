package com.ty.algorithm.test;

import com.ty.algorithm.sort.Bubble;

import java.util.Arrays;

/**
 * @author tanyun
 * @description
 * @date 2021/7/13 21:22
 */
public class BubbleTest {

    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,1};
        Bubble.sort(arr);
        System.out.println(Arrays.asList(arr));
    }

}
