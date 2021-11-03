package com.ty.algorithm.test;

import com.ty.algorithm.tree.RedBlackTree;

/**
 * 测试红黑树
 * @author tanyun
 * @description
 * @date 2021/9/14 20:37
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        // 创建红黑树
        RedBlackTree<String, String> tree = new RedBlackTree<>();
        tree.put("1","one");
        tree.put("2","two");
        tree.put("3", "three");
        tree.put("4", "four");

        String s = tree.get("3");
        System.out.println(s);

    }
}
