package com.ty.algorithm.test;

import com.ty.algorithm.linear.SequenceList;

import java.util.ArrayList;

/**
 * @author tanyun
 * @description
 * @date 2021/7/22 21:10
 */
public class SequenceListTest {

    public static void main(String[] args) {
        // 创建顺序表对象
        SequenceList<String> integerSequenceList = new SequenceList<String>(5);
        integerSequenceList.insert("1");
        integerSequenceList.insert("2");
        integerSequenceList.insert("3");
        integerSequenceList.insert("4");
        integerSequenceList.insert("5");
        integerSequenceList.insert("5");
        integerSequenceList.insert("5");
        integerSequenceList.insert("5");
        integerSequenceList.insert("6");
        integerSequenceList.insert(1,"7");
        System.out.println("长度为: " + integerSequenceList.length());
        System.out.println(integerSequenceList.get(1));
        System.out.println("删除了： "+integerSequenceList.remove(0));
        System.out.println("长度为: " + integerSequenceList.length());

        // 增强for循环
        for (String s : integerSequenceList) {
            System.out.println(s);
        }

    }




}
