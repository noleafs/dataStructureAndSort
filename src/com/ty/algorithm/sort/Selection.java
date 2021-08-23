package com.ty.algorithm.sort;

/**
 * 选择排序 它是不稳定排序算法
 * @author tanyun
 * @description
 * @date 2021/7/14 22:17
 */
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            // 假设索引i的值为最小
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
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
