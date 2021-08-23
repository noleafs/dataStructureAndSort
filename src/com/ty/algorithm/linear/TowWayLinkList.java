package com.ty.algorithm.linear;

import java.util.Iterator;

/**
 * 双向链表
 * @author tanyun
 * @description
 * @date 2021/7/23 22:12
 */
public class TowWayLinkList<T> implements Iterable<T> {

    /**
     * 记录头结点
     */
    private Node head;
    /**
     * 记录尾结点
     */
    private Node last;

    /**
     * 记录链表的长度
     */
    private int N;


    public TowWayLinkList() {
        // 初始化头结点
        this.head = new Node(null,null, null);
        this.last = null;
        this.N = 0;
    }


    /**
     * 清空链表
     */
    public void clean() {
        head.next = null;
        last = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        Node next = head.next;
        return next.item;
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    /**
     * 返回第i个元素的值
     * @param i
     * @return
     */
    public T get(int i) {
        Node node = head.next;
        for (int i1 = 0; i1 < i; i1++) {
            node = node.next;
        }
        return node.item;
    }

    /**
     * 添加元素
     * @param t
     */
    public void insert(T t) {

        if (isEmpty()) {
            Node newNode = new Node(t, null, head);
            head.next = newNode;
            last = newNode;
        } else {
            // 最后一个节点指向新节点
            Node newNode = new Node(t, null, last);
            // 让尾结点指向新节点
            last.next = newNode;
            // 让新节点成为尾结点
            last = newNode;
        }

        N++;
    }


    /**
     * 在指定元素i处，添加元素t
     * @param i
     * @param t
     */
    public void insert(int i, T t) {
        // 找到i位置前一个节点
        Node n = head;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        // 获得原本i处索引的node
        Node nextNode = n.next;
        // 创建新节点，下一个节点应是原本i处的节点，上一个节点是原本i处的上一个节点
        Node newNode = new Node(t,nextNode,n);
        if (newNode != null)
            nextNode.pre = newNode;
        n.next = newNode;
        N++;
    }


    /**
     * 删除指定位置i处的元素，并返回被删除的元素
     * @param i
     * @return
     */
    public T remove(int i) {
        Node n = head;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        // 找到i处的节点
        Node currNode = n.next;

        // i处的后一个节点
        Node nextNode = currNode.next;
        // 将i处的后一个节点，指向i处的前一个节点
        n.next = nextNode;
        nextNode.pre = n;
        N--;
        return currNode.item;
    }


    /**
     * 查找元素在链表中第一次出现的位置
     * @param t
     * @return
     */
    public int indexOf(T t) {
        Node n = head.next;
        for (int index = 0; n.next!=null; index++) {
            if (t.equals(n.item)) {
                return index;
            }
            n = n.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new TowIterator();
    }

    private class TowIterator implements Iterator{

        Node h = head;

        @Override
        public boolean hasNext() {
            return h.next != null;
        }

        @Override
        public Object next() {
            h = h.next;
            return h.item;
        }
    }


    private class Node {

        public T item;
        /**
         * 下一个结点
         */
        public Node next;
        /**
         * 上一个节点
         */
        public Node pre;

        public Node(T t, Node next, Node pre){
            item = t;
            this.next = next;
            this.pre = pre;
        }

    }


}
