package com.ty.algorithm.sort;

/**
 * 插入排序
 * @author tanyun
 * @description
 * @date 2021/7/15 20:54
 */
public class Insertion {


    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i;j > 0; j--) {
                // 比较索引j 和 索引j-1的值， 如果索引j-1的值大于j处的值，则交换，否则结束本次循环
                if ( greater(a[j-1], a[j])) {
                    // 交换元素
                    exch(a, j-1, j);
                } else {
                    // 因为前面都是已经排序好了的元素，如果判断中前一个等于或者小于当前未排序的元素， 就直接结束本次
                    break;
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
