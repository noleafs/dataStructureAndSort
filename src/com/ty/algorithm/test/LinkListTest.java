package com.ty.algorithm.test;

import com.ty.algorithm.linear.LinkList;
import com.ty.algorithm.linear.SequenceList;

/**
 * @author tanyun
 * @description
 * @date 2021/7/22 21:10
 */
public class LinkListTest {

    public static void main(String[] args) {
        // 创建单向链表对象
        LinkList<String> integerSequenceList = new LinkList<>();
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

        System.out.println("--------------------------------------");
        // 反转链表
        integerSequenceList.reverse();

        for (String s : integerSequenceList) {
            System.out.println(s);
        }
    }




}
