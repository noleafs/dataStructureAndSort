package com.ty.algorithm.test;


import com.ty.algorithm.linear.Queue;

/**
 * 折纸问题 树
 *      会有一个规律，第一次折的位置为下折痕， 左边为下折痕，右边为上折痕
 *      每折一次就相当于在每一个叶子结点上添加左子节点和右子节点
 * @author tanyun
 * @description
 * @date 2021/8/20 20:55
 */
public class PagerFoldingTest {

    public static void main(String[] args) {
        // 模拟折纸
        Node<String> tree = createTree(4);

        // 打印折纸
        printTree(tree);
    }

    /**
     * 模拟对折N次纸， 产生树
     * @param N
     * @return
     */
    public static Node<String> createTree(int N) {

        // 定义根节点
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            // 1.如果是第一次对折
            if (i == 0) {
                root = new Node<>("down", null, null);
                continue;
            }
            // 2.不是第一次对折
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);
            // 通过层序遍历找到叶子节点
            while (!queue.isEmpty()) {
                // 从队列中弹出一个结点
                Node<String> dequeue = queue.dequeue();
                if (dequeue.left != null) {
                    queue.enqueue(dequeue.left);
                }
                if (dequeue.right != null) {
                    queue.enqueue(dequeue.right);
                }
                // 当前节点的左子节点和右子节点都为空 则是叶子节点，只需要给该节点添加左子结点和右子节点即可
                if (dequeue.left == null && dequeue.right == null) {
                    // 下折痕
                    dequeue.left = new Node<String>("down", null, null);
                    // 上折痕
                    dequeue.right = new Node<String>("up", null, null);
                }

            }
        }

        return root;
    }


    /**
     * 打印树， 使用中序遍历来打印
     * @param root
     */
    public static void printTree(Node<String> root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            printTree(root.left);
        }
        // 打印当前节点
        System.out.println(root.item);

        if (root.right != null) {
            printTree(root.right);
        }


    }


    private static class Node<T> {
        private T item; // 存储元素

        // 存储左子节点
        private Node left;
        // 存储右子节点
        private Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }


    }


}
