package com.ty.algorithm.symbol;

import java.util.Iterator;

/**
 * 有序符号表
 * @author tanyun
 * @description
 * @date 2021/8/3 21:48
 */
public class OrderSymbolTable<Key extends Comparable<Key>,Value> implements Iterable<Value> {

    /**
     * 记录首结点
     */
    private Node head;
    /**
     * 记录元素中的个数
     */
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key,Value value) {
        // 记录当前结点
        Node curr = head.next;
        // 记录上一个结点
        Node pre = head;
        while(curr != null && key.compareTo(curr.key) > 0) {
            pre = curr;
            curr = curr.next;
        }

        // key如果一致，替换
        if (curr!=null && key.compareTo(curr.key) == 0) {
            curr.value = value;
            return;
        }

        // key不一致， 插入当前节点的前面
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;

        N++;

    }

    public void delete(Key key) {
        Node n = head;
        while(n.next != null) {
            Node suppNode = n;
            n = n.next;
            if (n.key.equals(key)) {
                suppNode.next = n.next;
                N--;
                return;
            }
        }
    }

    /**
     * 找到key对应的值
     * @param key
     * @return
     */
    public Value get(Key key) {
        Node n = head;
        while(n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

    @Override
    public Iterator<Value> iterator() {
        return new SyIterator();
    }

    private class SyIterator implements Iterator{
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.value;
        }
    }

    private class Node{
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}
