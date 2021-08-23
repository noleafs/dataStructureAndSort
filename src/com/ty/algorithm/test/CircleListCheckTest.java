package com.ty.algorithm.test;

/**
 * 快慢指针解决单向链表是否有环问题
 * 有环： 后面的节点指向了前面的结点， 反之就是无环
 *
 * @author tanyun
 * @description
 * @date 2021/7/28 20:27
 */
public class CircleListCheckTest {


    public static void main(String[] args) throws Exception {
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
        //产生环
        seven.next = third;
        //判断链表是否有环
        boolean circle = isCircle(first);
        System.out.println("first链表中是否有环：" + circle);
    }

    /**
     * 判断链表中是否有环
     *
     * @param first 链表首结点
     * @return ture为有环，false为无环
     */
    public static boolean isCircle(Node<String> first) {
        // 定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;

        // 结束条件为快指针没有下一个元素， 或者是快指针和慢指针重合
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }

        return false;
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
