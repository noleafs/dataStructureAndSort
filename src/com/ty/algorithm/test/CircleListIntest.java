package com.ty.algorithm.test;

/**
 * 链表的有环入口
 *      当快慢指针相遇时，我们可以判断到链表中是否有环，这时重新设定一个新指针指向链表的起点，且步长与慢指针一样为1， 当慢指针和这个新指针
 *      相遇的时候，这里就是环的入口。 这个结论牵涉到数论的知识 博客名（只识）
 * @author tanyun
 * @description
 * @date 2021/7/28 20:44
 */
public class CircleListIntest {

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
        //产生环
        seven.next = third;
        //查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为：" + entrance.item);
    }

    /**
     * 查找有环链表中环的入口结点
     *
     * @param first 链表首结点
     * @return 环的入口结点
     */
    public static Node getEntrance(Node<String> first) {

        // 定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;

        // 结束条件为快指针没有下一个元素
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (temp != null) {
                temp = temp.next;

                if (slow.equals(temp)) {
                    return temp;
                }
            }
            if (fast.equals(slow) && temp == null) {
                // 找到环后， 创建一个临时指针
                temp = first;
            }


        }
        return null;
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
