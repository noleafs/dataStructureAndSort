package com.ty.algorithm.test;

import com.ty.algorithm.sort.Student;

/**
 * @author tanyun
 * @description
 * @date 2021/7/9 21:31
 */
public class TestComparable {


    public static void main(String[] args) {
        Student s1 = new Student(20, "小明");
        Student s2 = new Student(25, "小白");
        Student maxStudent = (Student) getMax(s1, s2);
        System.out.println(maxStudent.getUsername()+"年龄比较大");
    }


    public static Comparable getMax(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        // 如果result小于0 则c1比c2小 ，否则反之
        // result == 0 两个相等
        if (result >= 0) {
            return c1;
        }
        return c2;
    }



}
