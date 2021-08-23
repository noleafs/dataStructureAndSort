package com.ty.algorithm.test;

import com.ty.algorithm.linear.Stack;

/**
 * @author tanyun
 * @description
 * @date 2021/7/29 21:30
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println("栈内元素个数： " + stack.size());
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

}
