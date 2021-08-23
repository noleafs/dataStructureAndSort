package com.ty.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author tanyun
 * @description
 * @date 2021/7/20 20:18
 *
 *  切分原理：
 *     把一个数组切分成两个子数组的基本思想
 *      1. 找一个基准值，用两个指针分别指向数组的头部和尾部
 *      2. 先从尾部向头部开始搜索一个比基准值小的元素，搜索到即停止，并记录指针的位置
 *      3. 再从头部向尾部开始搜索一个比基准值大的元素，搜索到即停止，并记录指针的位置
 *      4. 交换当前左边指针位置和右边指针位置的元素；
 *      5. 重复2,3,4步骤，直到左边指针的值大于或者等于右边指针的值停止，当满足这个条件，左右两边的指针一样大，那么这个指针就是这个基准值，它需要和头部的第一个指针进行交换
 *
 *
 *      自己的理解： 归并排序是在将数组分好组后，在合并的过程中进行了排序
 *                 快速排序是在分组过程中就已经进行了排序
 *      它是不稳定排序算法
 */
public class Quick {


    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length-1;
        sort(a, lo ,hi);
    }

    /**
     * 对数组a中 从索引lo到索引hi之间的元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi) {

        // 结束条件
        if (hi <= lo) {
            System.out.println(Arrays.asList(a));
            return;
        }

        int partition = partition(a, lo, hi);

        // 让左子组有序
        sort(a, lo, partition-1);

        // 让右子组有序
        sort(a, partition+1, hi);

    }

    /**
     * 对数组a中，从索引lo到索引hi之间的元素进行分组
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a, int lo, int hi) {
        // 确定分界值
        Comparable key = a[lo];
        // 定义两个指针，分别指向待切分（a）数组的最小索引和最大索引的下一个位置
        int left = lo;
        int right = hi+1;

        // 切分

        while(true) {
            // 先从右向左扫描，移动right指针，找到比分界值小的元素，停止
//            while(less(key, a[--right])) {
//                if (right <= left) {
//                   break;
//                };
//            }
//
//            System.out.println(left == right);
////            // 先从左向右扫描，移动left指针，找到比分界值大的元素，停止
//            while (less(a[++left], key)) {
//                if (left >= right) break;
//            }

            while(less(key, a[--right])) {
                if (right <= left) break;
            }
//             先从左向右扫描，移动left指针，找到比分界值大的元素，停止
            while (left < right && less(a[++left], key)) {
            }


            // 代表所有元素扫描完毕
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }

        }

        System.out.println("left: " + left + " right: " + right);
        // 最后需要跟第一个元素进行交换， 交换分界值
        exch(a, lo, left);

        return left;
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
