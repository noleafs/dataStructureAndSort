package com.ty.algorithm.test;

import com.ty.algorithm.heap.Heap;

/**
 * @author tanyun
 * @description
 * @date 2021/8/25 21:01
 */
public class HeapTest {

    public static void main(String[] args) {
        // 创建堆对象
        Heap<String> heap = new Heap<String>(12);

        // 往堆中存入字符串数据
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        // 从堆中删除数据
        String s;
        while ((s = heap.delMax()) != null) {
            System.out.println(s);
        }

    }
}
