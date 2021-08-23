package com.ty.algorithm.sort;

/**
 * 归并排序
 * 对数组先进行分组，一直分成子组元素为1的时候，
 * 然后对子组进行排序合并
 *
 * @author tanyun
 * @description
 * @date 2021/7/16 21:58
 *
 *  1.尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是1为止。
 *  2.将相邻的两个子组进行合并成一个有序的大组；
 *  3.不断的重复步骤2，直到最终只有一个组为止。
 *
 */
public class Merge {

    /**
     * 归并所需要的辅助数组
     */
    private static Comparable[] assist;

    public static void sort(Comparable[] a) {
        // 1.初始化辅助数组assist；
        assist = new Comparable[a.length];
        // 2.定义一个lo变量和hi变量，分别记录数组中最小的索引和最大的索引
        int io = 0;
        int hi = a.length - 1;
        // 3.调用sort重载方法完成数组a中，从索引io到索引hi的元素的排序
        sort(a, io, hi);
    }

    /**
     * 对数组a 进行分组
     *
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        // 安全性校验
        if (hi <= lo) {
            return;
        }
        ;
        // 对lo到hi之间的数据进行分组
        int mid = lo + (hi - lo) / 2;

        // 分别对每一组数据进行排序
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        // 在将两个组中的数据进行归并
        merge(a, lo, mid, hi);

    }

    /**
     * 核心
     * 从索引io 到 索引mid为一个子组， 从索引 mid+1 到索引hi为另一个子组，把数组a
     * 中的这两个子组的数据合并为一个有序的大组
     *
     * @param a
     * @param io
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int io, int mid, int hi) {
        // 定义三个指针
        // 左子组
        int p1 = io;
        // 右子组
        int p2 = mid + 1;
        // 辅助数组
        int i = io;

        /*
            比较两个子组的值，把小的值放入赋值数组中
            移动
         */
        while (p1 <= mid && p2 <= hi) {
            // 比较对应索引处的值
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }

        // 如果p1的指针没有走完， 将p1剩下的值顺序移入辅助数组中
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }

        // 如果p2的指针没有走完，将p2剩下的值顺序移入辅助数组中
        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }


        // 走到这里，两个分组合并有序大分组已经完成， 需要将辅助数组中的有序元素，拷贝到源数组中
        for (int j = io; j <= hi; j++) {
            a[j] = assist[j];
        }


    }


    /**
     * v 是否小于 w
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
