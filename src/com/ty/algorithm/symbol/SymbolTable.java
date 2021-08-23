package com.ty.algorithm.symbol;

import java.util.Iterator;

/**
 * 符号表
 * @author tanyun
 * @description
 * @date 2021/8/3 21:48
 */
public class SymbolTable<Key,Value> implements Iterable<Value> {

    /**
     * 记录首结点
     */
    private Node head;
    /**
     * 记录元素中的个数
     */
    private int N;

    public SymbolTable() {
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key,Value value) {
        // 两种情况， 一是存在这个key进行替换，而是不存在这个key添加
        Node n = head;
        while(n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }

        // 不存在这个key
        Node newNode = new Node(key, value, null);
        Node next = head.next;
        newNode.next = next;
        head.next = newNode;

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
