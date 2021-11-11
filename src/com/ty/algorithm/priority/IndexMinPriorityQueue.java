package com.ty.algorithm.priority;

/**
 * @author tanyun
 * @description
 * @date 2021/9/3 20:00
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {

    /**
     * 存储元素的数组
     */
    private T[] items;

    /**
     * 保存每个元素在items数组中的索引，pq数组需要堆有序。 相当于是对元素对应的索引进行了排序
     */
    private int[] pq;

    /**
     * 保存qp的逆序，pq的值作为索引，pq的索引作为值，通过这个就可以快速找到元素在pq中存在的位置
     */
    private int[] qp;

    private int N;


    public IndexMinPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;

        // 默认情况下队列中没有存储任何数据，让qp中的元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }

    }

    /**
     *
     * @param i pq堆的索引
     * @param j pq堆的索引
     * @return
     */
    private boolean less(int i, int j) {
        int i1 = pq[i];
        int i2 = pq[j];
        return items[i1].compareTo(items[i2]) < 0;
    }


    private void exch(int i, int j) {
        // 交换pq中的数据
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        // 更新pq中的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {

        return N == 0;
    }

    /**
     * 判断k对应的元素是否存在
     * @param k
     * @return
     */
    public boolean contains(int k) {

        return qp[k] != -1;
    }


    /**
     * 把与索引i关联的元素修改为为t
     * @param i
     * @param t
     */
    public void changeite(int i, T t) {
        // 修改items数组中i位置元素为t
        items[i] = t;
        // 找到i在pq中出现的位置
        int index = qp[i];
        // 堆调整
        sink(index);
        swim(index);
    }

    /**
     * 最小元素关联的索引
     * @return
     */
    public int minIndex() {
        return pq[1];
    }


    /**
     * 删除索引i关联的元素
     * @param i items的索引
     */
    public void delete(int i) {
        // 索引i不存在
        if (!contains(i)) {
            return;
        }

        // 找到i在qp中的索引
        int k = qp[i];
        exch(k, N);
        // 删除pq中的
        pq[N] = -1;
        // 删除qp中的
        qp[i] = -1;
        // 删除items中的
        items[i] = null;

        N--;

        // 需要对交换后的元素 进行堆有序调整
        sink(k);
        swim(k);
    }



    /**
     * 删除队列中最小的元素,并返回该元素关联的索引
     * @return 索引
     */
    public int delMin() {
        int min = pq[1];
        exch(1, N);

        // 删除qp中的数据
        qp[pq[N]] = -1;

        // 删除items中的元素
        items[pq[N]] = null;

        pq[N] = -1;

        N--;
        // 通过下层算法 保证堆有序
        sink(1);

        return min;
    }

    /**
     * 往队列中插入一个元素,并关联索引i
     * @param i
     * @param t
     */
    public void insert(int i,T t){
        // 判断i是否已经被关联，如果已经被关联，则不让插入
        if (contains(i)) {
            return;
        }
        // 元素个数加1
        N++;
        // 把数据存储到items对应的i位置
        items[i] = t;
        // 把i存储pq中
        pq[N] = i;
        // 通过qp来记录pq中的i
        qp[i] = N;

        // 会破坏堆的有序，通过堆上浮完成堆的调整
        swim(N);
    }

    /**
     * 上浮算法
     * @param k
     */
    private void swim(int k) {
        while(k > 1) {
            if (less(k, k/2)) {
                exch(k, k/2);
                k = k/2;
            } else {
                break;
            }
        }
    }

    /**
     * 下沉算法
     * @param k
     */
    private void sink(int k) {
        while (k*2 <= N) {
            int min;
            // 有右子结点
            if (k*2+1 <= N) {
                if (less(k*2, k*2+1)) {
                    min = k*2;
                } else {
                    min = k*2+1;
                }
            } else {
                min = k*2;
            }


            if (less(k, min)) {
                break;
            }

            exch(k, min);
            k = min;

        }


    }



}
