package com.ty.algorithm.test;

import com.ty.algorithm.priority.IndexMinPriorityQueue;

/**
 * @author tanyun
 * @description
 * @date 2021/9/7 21:11
 */
public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<String>(10);

        queue.insert(0, "A");
        queue.insert(1, "D");
        queue.insert(2, "C");
        queue.insert(3, "B");
        queue.insert(4, "G");

        // 测试修改
        queue.changeite(3, "H");

        // 测试删除
        while(!queue.isEmpty()) {
            int i = queue.delMin();
            System.out.println(i);
        }
    }
}
