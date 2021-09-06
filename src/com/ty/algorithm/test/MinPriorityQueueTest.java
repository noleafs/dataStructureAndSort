package com.ty.algorithm.test;

import com.ty.algorithm.priority.MaxPriorityQueue;
import com.ty.algorithm.priority.MinPriorityQueue;

/**
 * @author tanyun
 * @description
 * @date 2021/8/31 20:54
 */
public class MinPriorityQueueTest {

    public static void main(String[] args) {
        // 创建最小优先队列
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");

       while(!queue.isEmpty()) {
           System.out.println(queue.delMin());
       }

    }
}
