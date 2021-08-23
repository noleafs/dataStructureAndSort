package com.ty.algorithm.test;

import com.ty.algorithm.linear.Stack;

/**
 * 括号匹配问题
 * @author tanyun
 * @description
 * @date 2021/8/2 20:15
 */
public class BracketMatchTest {

    public static void main(String[] args) {
        String str = "(四川(成都)())";
        boolean match = isMatch(str);
        System.out.println("括号是否匹配：" + match);
    }


    /**
     * 判断str中的括号是否匹配
     * @param str
     * @return
     */
    public static boolean isMatch(String str) {

        // 1.创建栈对象，用来存储左括号
        Stack<String> chars = new Stack<>();

        for (char c : str.toCharArray()) {
            if ("(".equals(c+"")) {
                chars.push(c+"");
            } else if (")".equals(c+"")) {
                String pop = chars.pop();
                if (pop == null) {
                    return false;
                }
            }
        }

        // 判断栈中是否还有左括号
        return chars.isEmpty();
    }


}
