package com.ty.algorithm.linear;

import java.util.Iterator;

/**
 * @author tanyun
 * @description
 * @date 2021/8/3 20:03
 */
public class Queue<T> implements Iterable<T>{

    /**
     * 首节点
     */
    private Node head;

    /**
     * 最后一个节点
     */
    private Node last;

    /**
     * 元素个数
     */
    private int N;

    public Queue() {
        this.N = 0;
        this.head = new Node(null, null);
        this.last = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator{
        private Node head = Queue.this.head;

        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        @Override
        public Object next() {
            head = head.next;
            return head.item;
        }
    }


    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public void enqueue(T t) {
        Node node = new Node(t, null);
        // 尾结点last为null
        if (last == null) {
            head.next = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
    }

    // 从队列中拿出元素
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node oldNode = head.next;
        head.next = oldNode.next;
        N--;
        if (isEmpty()) {
            last = null;
        }

        return oldNode.item;
    }




}
