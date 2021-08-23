package com.ty.algorithm.sort;

/**
 * 希尔排序： 插入排序的改良版，本质是将要排序的数字进行分组，然后来进行插入排序
 *           它是不稳定排序算法
 * @author tanyun
 * @description
 * @date 2021/7/16 19:45
 */
public class Shell {

    public static void sort(Comparable[] a) {
        // 1.根据要排序的长度，确定增长量 h
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        // 2.希尔排序
        while (h >= 1) {
            // 排序
            // 2.1找到待插入的元素
            for (int i = h; i < a.length; i++) {
                // 2.2 找到待插入元素的前一个元素进行比较， 小则交换，内部就是一个插入排序
                for (int j = i; j >= h; j -= h) { // 找到同一组的， 插入排序
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }

            // 对增长量进行减小
            h = h / 2;
        }


    }


    /**
     * 比较元素 v 是否大于 w
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }


    /**
     * 交换指定元素的位置
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable z = a[j];
        a[j] = a[i];
        a[i] = z;
    }
}
