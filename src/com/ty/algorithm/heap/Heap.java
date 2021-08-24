package com.ty.algorithm.heap;

/**
 * 堆数据结构
 * @author tanyun
 * @description
 * @date 2021/8/24 21:31
 */
public class Heap<T extends Comparable<T>> {

    /**
     * 存储堆中的元素
     */
    private T[] items;

    /**
     * 记录堆中元素的个数
     */
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.N = 0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }


    /**
     * 交换堆中i索引和j索引处的值
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        T temporary = items[i];
        items[i] = items[j];
        items[j] = temporary;
    }


    /**
     * 删除堆中最大的元素，并返回这个最大元素
     * @return
     */
    public T delMax() {
        return null;
    }

    /**
     * 往堆中插入一个元素
     * @param t
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }


    /**
     * 使用上浮算法， 使索引k处的元素能在堆中处于一个正确的位置, 因为新插入的元素需要保证是小于父结点的。 堆的特征
     *      当前索引处的元素，跟它的父结点进行对比，如果大于父结点则交换位置，一直持续到不大于父结点位置
     * @param k
     */
    private void swim(int k) {
        // 通过循环，不断的比较当前结点的值和其父结点的值，如果发现父结点的值比当前结点的值小则交换位置
        while (k > 0 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }


    /**
     * 使用下浮算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void sink(int k) {

    }



}
