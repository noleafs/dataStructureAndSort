package com.ty.algorithm.test;

import com.ty.algorithm.tree.BinaryTree;

/**
 * @author tanyun
 * @description
 * @date 2021/8/12 22:39
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        //测试插入
        tree.put(1,"张三");
        tree.put(2,"李四");
        tree.put(3,"王五");
        tree.put(4,"二麻子");

        System.out.println("插入完毕后元素的个数：" + tree.size());

        // 测试获取
        System.out.println("键2对应的元素是： " + tree.get(2));

        // 测试删除
        tree.delete(3);
        System.out.println("删除后元素的个数：" + tree.size());
        System.out.println("键3对应的元素是： " + tree.get(3));


        System.out.println("最小的键为：" + tree.min());
    }
}
