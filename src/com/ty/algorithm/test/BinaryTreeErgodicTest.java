package com.ty.algorithm.test;

import com.ty.algorithm.linear.Queue;
import com.ty.algorithm.tree.BinaryTree;

/**
 * @author tanyun
 * @description
 * @date 2021/8/17 19:41
 */
public class BinaryTreeErgodicTest {

    public static void main(String[] args) {
        // 创建树对象
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        // 前序遍历
        Queue<String> keys = bt.preErgodic();
        for (String key : keys) {
            System.out.print(key);
        }
        System.out.println();
        // 中序遍历
        keys = bt.midErgodic();
        for (String key : keys) {
            System.out.print(key);
        }
        System.out.println();
        // 后序遍历
        keys = bt.afterErgodic();
        for (String key : keys) {
            System.out.print(key);
        }

        System.out.println();
        // 层序遍历
        keys = bt.layerErgodic();
        for (String key : keys) {
            System.out.print(key);
        }

        System.out.println();
        System.out.println("最大深度为： " + bt.maxDepth());


    }

}
