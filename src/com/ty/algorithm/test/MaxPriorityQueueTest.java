package com.ty.algorithm.test;

import com.ty.algorithm.priority.MaxPriorityQueue;

/**
 * @author tanyun
 * @description
 * @date 2021/8/31 20:54
 */
public class MaxPriorityQueueTest {

    public static void main(String[] args) {
        // 创建优先队列
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<String>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

       while(!queue.isEmpty()) {
           System.out.println(queue.delMax());
       }
    }
}
