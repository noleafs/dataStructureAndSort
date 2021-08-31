package com.ty.algorithm.priority;

/**
 * 优先队列，采用堆的方式来实现
 * @author tanyun
 * @description
 * @date 2021/8/30 21:10
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    // 存储堆中的元素
    private T[] items;
    /**
     * 堆中元素的个数
     */
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    /**
     * 获取队列中元素的个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 队列是否为空
     * @return
     */
    private boolean isEmpty() {
        return N == 0;
    }

    /**
     * 堆中索引处i处的元素是否小于j处的元素
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中 i 和 j索引处的值
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
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
     * 删除堆中最大的元素，并返回这个最大元素
     * @return
     */
    public T delMax() {
        T max = items[1];
        exch(1,N);
//        items[N] = null;
        N--;

        // 下层调整堆的有序
        sink(1);
        return max;
    }


    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void swim(int k) {
        while (N > 1) {
            if (less( k/2, k)) {
                exch(k/2, k);
                k = k/2;
            } else {
                break;
            }
        }

    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置, 使用当前结点对比子节点中最大的结点
     * @param k
     */
    private void sink(int k) {

        // 至少要用左子结点才能进行下层
        while(k*2 <= N) {
            int max;
            if (k*2+1 <= N) {
                if (less(k*2, k*2+1)) {
                    max = k*2+1;
                } else {
                    max = k*2;
                }
            } else {
                max = k*2;
            }

            // 对比当前结点和最大的子结点
            if (!less(k, max)) {
                break;
            }
            // 下沉
            exch(k, max);
            k = max;

        }
    }



}
