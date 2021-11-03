package com.ty.algorithm.tree;

/**
 * 红黑树的实现
 * @author tanyun
 * @description
 * @date 2021/9/13 20:26
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    // 根节点
    private Node root;
    // 记录树中元素的个数
    private int N;

    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private class Node {
        // 存储键
        private Key key;
        // 存储值
        private Value value;
        // 存储左子结点
        private Node left;
        // 存储右子结点
        private Node right;
        // 其父结点指向它的链接的颜色
        public boolean color;


        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

        /**
         * 获取树中元素的个数
         * @return
         */
        public int size() {
            return N;
        }

        /**
         * 判断当前节点的父指向链接是否为红色
         * @param x
         * @return
         */
        private boolean isRed(Node x) {
            if (x == null) {
                return false;
            }
            return x.color == RED;
        }

        /**
         * 左旋转
         * @param h 返回左旋后的右节点
         * @return
         */
        private Node rotateLeft(Node h) {
            // 获取h结点的右子结点，表示为x
            Node x = h.right;
            // 让x结点的左子结点成为h节点的右子结点
            h.right = x.left;
            // 让h成为x结点的左子结点
            x.left = h;
            // 让x结点的color属性等于h结点的color属性
            x.color = h.color;
            // 让h结点的color属性变为红色
            h.color = RED;
            return x;
        }

        /**
         * 右旋
         * @param h
         * @return
         */
        private Node rotateRight(Node h) {
            // 获取h结点的左子结点，表示为x
            Node x = h.left;
            // 让x结点的右子结点成为h结点的左子结点
            h.left = x.right;
            // 让h结点称为x结点的右子结点
            x.right = h;
            // 让x结点的color属性等于h结点的color属性
            x.color = h.color;
            // 让h结点的color属性为红色
            h.color = RED;
            return x;
        }

        /**
         * 颜色反转
         *      -4结点
         * @param h
         */
        private void flipColors(Node h) {
            // 当前结点变为红色
            h.color = RED;
            // 左子结点和右子结点变为黑色
            h.left.color = BLACK;
            h.right.color = BLACK;
        }


        /**
         * 在整个树上完成插入操作
         * @param key
         * @param val
         */
        public void put(Key key, Value val) {
            root = put(root, key, val);
            // 跟结点的颜色总是黑色
            root.color = BLACK;
        }


        /**
         * 在指定树中，完成插入操作，并返回添加元素后的树
         * @param h
         * @param key
         * @return
         */
        private Node put(Node h, Key key, Value val) {
            // 判断h是否为空，如果为空则直接返回一个红色的结点就可以了
            if(h == null) {
                N++;
                return new Node(key, val, null, null, RED);
            }
            // 比较h结点的键和key的大小
            int cmp = h.key.compareTo(key);
            if (cmp > 0) {
                // 继续往左
                h.left = put(h.left, key, val);
            } else if (cmp < 0) {
                // 继续往右
                h.right = put(h.right, key, val);

            } else {
                h.key = key;
                h.value = val;
            }

            // 需要进行调整
            // 进行左旋；当前结点h的左子结点为黑色，右子结点为红色，需要左旋
            if (isRed(h.right) && !isRed(h.left)) {
               h = rotateLeft(h);
            }
            // 右旋,当前结点的左子结点和左子结点的左子结点
            if (isRed(h.left) && isRed(h.left.left)) {
                h = rotateRight(h);
            }

            // 反转, 当前结点的左子结点和右子结点都为红色
            if (isRed(h.left) && isRed(h.right)) {
                flipColors(h);
            }


            return h;
        }

        // 根据key，从树中找到对应的值
        public Value get(Key key) {
            Node node = root;
            while (node != null) {
                int cmp = node.key.compareTo(key);
                if (cmp > 0) {
                    System.out.println("左树");
                    node = node.left;
                } else if (cmp < 0) {
                    System.out.println("右树");
                    node = node.right;
                } else {
                    return node.value;
                }
            }
            if (node == null) {
                return null;
            }
            return node.value;
        }




}
