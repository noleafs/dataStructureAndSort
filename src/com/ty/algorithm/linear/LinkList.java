package com.ty.algorithm.linear;

import java.util.Iterator;

/**
 * 单向链表
 * @author tanyun
 * @description
 * @date 2021/7/23 22:12
 */
public class LinkList<T> implements Iterable<T> {

    /**
     * 记录头结点
     */
    private Node head;

    /**
     * 记录链表的长度
     */
    private int N;



    /**
     * 节点类
     */
    private class Node {
        // 存储数据
        T item;
        // 下一个节点
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        // 初始化头结点
        this.head = new Node(null,null);
        this.N = 0;
    }


    /**
     * 清空链表
     */
    public void clean() {
        head.next = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
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
        // 找到最后一个节点
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }

        // 最后一个节点指向新节点
        node.next = new Node(t, null);
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
        // 将i处前的节点指向新节点
        Node newNode = new Node(t,nextNode);
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
        return new Iter();
    }

    public class Iter implements Iterator {
        private Node n;

        public Iter() {
            n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }


    // 反转整个链表
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }

        // 递归的反转当前节点curr的下一个节点， 返回值就是当前节点的下一个节点，
        Node reverse = reverse(curr.next);
        // 让返回的节点的下一个节点变为当前节点curr
        reverse.next = curr;
        // 把当前节点的下一个节点变为null
        curr.next = null;
        return curr;
    }
}
