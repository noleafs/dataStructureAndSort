package com.ty.algorithm.linear;


import java.util.Iterator;

/**
 * 栈，栈数据结构只是一个逻辑层面的数据结构， 所以需要用到物理存储结构： 两种，顺序存储结构（常见的就是数组），链式存储结构（常见的就是链表）
 *               此时用链表实现
 * @author tanyun
 * @description
 * @date 2021/7/29 21:14
 */
public class Stack<T> implements Iterable<T> {

    // 记录首结点
    private Node head;
    // 记录元素个数
    private int N;

    public Stack(){
        this.N = 0;
    }

    /**
     * 判断当前栈中元素个数是否为0
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取栈中元素的个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 压栈， 入栈
     * @param t
     */
    public void push(T t) {
        Node newNode = new Node(t, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        N++;
    }


    /**
     * 出栈，弹栈
     * @return
     */
    public T pop() {
        Node thisNode = head;
        if (head == null) {
            return null;
        }
        Node nextNode = head.next;
        head = nextNode;
        N--;
        return thisNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator{

        private Node head = Stack.this.head;

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public Object next() {
            Node next = head.next;
            Node thisNode = head;
            head = next;
            return thisNode.item;
        }
    }



    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
