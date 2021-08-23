package com.ty.algorithm.test;

import com.ty.algorithm.linear.LinkList;
import com.ty.algorithm.linear.TowWayLinkList;

import java.util.LinkedList;

/**
 * @author tanyun
 * @description
 * @date 2021/7/22 21:10
 */
public class TowWayLinkTest {

    public static void main(String[] args) {
        // 创建双向链表对象
        TowWayLinkList<String> integerSequenceList = new TowWayLinkList<>();
        integerSequenceList.insert("1");
        integerSequenceList.insert("2");
        integerSequenceList.insert("3");
        integerSequenceList.insert("4");
        integerSequenceList.insert("5");
        integerSequenceList.insert("5");
        integerSequenceList.insert("5");
        integerSequenceList.insert("5");
        integerSequenceList.insert("6");
        // 增强for循环
        for (String s : integerSequenceList) {
            System.out.println(s);
        }

        System.out.println("删除指定索引处的元素" + integerSequenceList.remove(0));
        // 增强for循环
        for (String s : integerSequenceList) {
            System.out.println(s);
        }
        integerSequenceList.insert(1,"33");
        System.out.println("-----------------------------");
        for (String s : integerSequenceList) {
            System.out.println(s);
        }

        System.out.println("首结点为：" + integerSequenceList.getFirst());
        System.out.println("尾结点为：" + integerSequenceList.getLast());

        // 采用双向链表实现
        LinkedList<Integer> linkList = new LinkedList<>();

    }




}
