package com.ty.algorithm.test;

/**
 * 快慢指针解决中间值问题
 *          定义一个快指针，一个满指针，快指针为满指针二倍。 当快指针走完整个链表时，满指针正好走到链表的一半
 * @author tanyun
 * @description
 * @date 2021/7/27 21:39
 */
public class FastSlowTest {


    public static void main(String[] args) {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);
        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值为：" + mid);
    }

    /**
     * @param first 链表的首结点
     * @return 链表的中间结点的值
     */
    public static String getMid(Node<String> first) {
        // 定义两个指针
        Node<String> slowNode = first;
        // 快指针
        Node<String> fastNode = first;
        // 当快指针指向的节点没有下一个节点了，就可以结束了
        while(fastNode != null && fastNode.next != null) {
            // 变化fast的值和slow的值
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode.item;
    }

    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


}


