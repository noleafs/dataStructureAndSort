package com.ty.algorithm.test;

/**
 * 约瑟夫问题
 * @author tanyun
 * @description
 * @date 2021/7/28 21:47
 */
public class JosephTest {

    public static void main(String[] args) {

        // 1.构建41个节点的循环链表
        Node<Integer> node = null;
        Node<Integer> head = null;
        for (int i = 1; i <= 41; i++) {
            Node<Integer> curr = new Node<>(i, null);
            if (i == 1) {
                node = head  = curr;
                continue;
            }
            node.next = curr;
            node = node.next;
        }
        // 循环链表
        node.next = head;

        // 2.模拟报数
        int count = 0;

        // 3.开始游戏
        // 记录当前节点的上一个节点
        Node<Integer> n = head;
        Node<Integer> before = null;

        while(true) {
            if (n.next.next.equals(n)) {
                break;
            }
            // 如果是3，则把当前节点删除， 打印当前节点
            ++count;

            if (count == 3) {
                System.out.println(n.item + " ：结点退出游戏");
                count = 0;
                before.next = n.next;
            } else {
                before = n;
            }
            n = n.next;
        }

        System.out.println("最后存活的为：" + n.item + "," + n.next.item);


    }


    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item,Node next) {
            this.item = item;
            this.next = next;
        }
    }


}
