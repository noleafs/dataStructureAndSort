package com.ty.algorithm.test;

import com.ty.algorithm.heap.HeapSort;

/**
 * @author tanyun
 * @description
 * @date 2021/8/27 21:12
 */
public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数据
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};

        HeapSort.sort(arr);

        for (String s : arr) {
            System.out.println(s);
        }


    }
}
