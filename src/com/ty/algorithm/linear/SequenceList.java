package com.ty.algorithm.linear;

import java.util.Iterator;
import java.util.Objects;

/**
 * 顺序表
 * @author tanyun
 * @description
 * @date 2021/7/21 22:34
 */
public class SequenceList<T> implements Iterable<T> {

    /**
     * 存储元素的数组
     */
    private T[] eles;
    /**
     * 顺序表中的元素个数
     */
    private int N;

    public SequenceList(int capacity) {
        // 初始化数据
        this.eles = (T[])new Object[capacity];
        // 初始化长度
        this.N = 0;
    }

    /**
     * 将顺序表置为空
     */
    public void clear() {
        this.N = 0;
    }

    /**
     * 当前顺序是否为空表
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取线性表的长度
     * @return
     */
    public int length() {
        return N;
    }

    /**
     * 获取指定位置的元素
     * @param i
     * @return
     */
    public T get(int i) {
        return eles[i];
    }


    /**
     * 向顺序表中添加元素
     * @param t
     */
    public void insert(T t) {
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        eles[N++] = t;
    }

    /**
     * 在指定位置处插入元素
     * @param i
     * @param t
     */
    public void insert(int i, T t)  {
        if (N == eles.length) {
            resize(eles.length * 2);
        }

        // 将i索引处及其后面的元素一次向后移动一位
        for (int index = N; index >= i; index--) {
            eles[index] = eles[index-1];
        }

        // 在把t元素放入i索引即可
        this.eles[i] = t;
        N++;
    }

    /**
     * 删除指定位置的元素，并返回该元素
     * @param i
     * @return
     */
    public T remove(int i) {
        // 记录索引i处的值
        T current = eles[i];
        // 让索引后面的元素依次向前移动一步
        for (int index = i; index < N-1; index++) {
            eles[index] = eles[index+1];
        }
        // 元素个数-1
        N--;
        if (N < (eles.length / 4)) {
            resize(eles.length / 2);
        }
        return current;
    }

    /**
     * 查找T元素第一次出现的位置
     * @param t
     * @return
     */
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据参数newSize， 重置else的大小
     * @param newSize
     */
    public void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i=0; i<N; i++) {
            temp[i] = eles[i];
        }
        eles = temp;
    }


    @Override
    public Iterator<T> iterator() {
        return new Siterator();
    }


    private class Siterator implements Iterator {

        private int cusor;
        public Siterator() {
            cusor = 0;
        }

        /**
         * 是否还有下一个元素
         * @return
         */
        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}
