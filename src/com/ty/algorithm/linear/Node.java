package com.ty.algorithm.linear;

/**
 * @author tanyun
 * @description
 * @date 2021/7/23 22:00
 */
public class Node<T> {

    public T item;
    /**
     * 下一个结点
     */
    public Node next;
    /**
     * 上一个节点
     */
    public Node pre;

    public Node(T t, Node next){
        item = t;
        this.next = next;
    }

}
