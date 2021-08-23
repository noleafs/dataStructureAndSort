package com.ty.algorithm.sort;

/**
 * @author tanyun
 * @description
 * @date 2021/7/13 21:01
 */
public class Bubble {

    /**
     * 冒泡排序
     * 对数组进行排序
     */
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (greater(a[j], a[j+1])){
                    exch(a, j, j+1);
                }
            }
        }
    }


    /**
     * 比较元素 v 是否大于 w
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }


    /**
     * 交换指定元素的位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j){
        Comparable z = a[j];
        a[j] = a[i];
        a[i] = z;
    }


}
