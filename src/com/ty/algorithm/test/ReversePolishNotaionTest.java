package com.ty.algorithm.test;

import com.ty.algorithm.linear.Stack;

/**
 * @author tanyun
 * @description
 * @date 2021/8/2 21:10
 */
public class ReversePolishNotaionTest {

    public static void main(String[] args) {
        // 中缀表达式 3 * (17-15) + 18 /6 的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为： " + result);
    }

    private static int caculate(String[] notation) {
        // 1.定义一个栈，存储操作数
        Stack<Integer> oprands = new Stack<>();
        // 2.从左往右遍历逆波兰表达式，得到每一个元素
        for (String s : notation) {

            Integer o2;
            Integer o1;
            // 3. 是否是运算符
            switch (s) {
                case "+":
                    // 4. 是运算符，从栈中弹出两个操作数，完成运算。在将运算完的结果压入栈中
                    o2 = oprands.pop();
                    o1 = oprands.pop();
                    oprands.push(o1+o2);
                    break;
                case "-":
                    o2 = oprands.pop();
                    o1 = oprands.pop();
                    oprands.push(o1-o2);
                    break;
                case "*":
                    o2 = oprands.pop();
                    o1 = oprands.pop();
                    oprands.push(o1*o2);
                    break;
                case "/":
                    o2 = oprands.pop();
                    o1 = oprands.pop();
                    oprands.push(o1/o2);
                    break;
                default:
                    // 5. 不是就是操作数，压入栈中
                    oprands.push(Integer.parseInt(s));
                    break;
            }
        }
        // 6.栈中只有最后一个元素，这就是结果
        Integer result = oprands.pop();

        return result;
    }

}
