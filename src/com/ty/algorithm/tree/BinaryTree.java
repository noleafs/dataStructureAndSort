package com.ty.algorithm.tree;

import com.ty.algorithm.linear.Node;
import com.ty.algorithm.linear.Queue;

/**
 * 二叉链表， 使用链表实现二叉树， 也可以用顺序结构实现，但是顺序结构实现比较适合完全二叉树
 * @author tanyun
 * @description
 * @date 2021/8/11 20:30
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    // 记录根结点
    private Node root;
    // 记录树中元素的个数
    private int N;

    private class Node {
        private Key key;
        private Value value;

        // 存储左子节点
        private Node left;
        // 存储右子节点
        private Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }


    /**
     * 返回元素的个数
     * @return
     */
    public int size() {
        return N;
    }


    /**
     * 向树中添加元素key-value
     *      如果新节点的key小于当前结点的key，则继续找当前结点的左子结点
     *      如果新节点的key大于当前结点的key，则继续找当前结点的右子结点
     *      如果新节点的key等于当前结点的key，则树中已经存在这样的节点，替换该结点的value值即可
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 向指定的树x中添加key-value，并返回添加元素后的树
     * @param x
     * @param key
     * @param value
     * @return
     */
    public Node put(Node x, Key key, Value value) {
        // 如果子树为空，
        if (x == null) {
            ++N;
            return new Node(key, value, null, null);
        }

        // 子树不为空
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 如果新节点的key大于当前结点的key，则继续找当前结点的右子结点
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            // 如果新节点的key小于当前结点的key，则继续找当前结点的左子结点
            x.left = put(x.left, key, value);
        } else {
            // key等于
            x.value = value;
        }

        return x;
    }


    /**
     * 根据key找到对应的value
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }


    public Value get(Node x, Key key) {
        // 可能会查找到左子树或者右子树为空的情况
        if (x == null) {
            return null;
        }

        // 子树不为空
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 如果新节点的key大于当前结点的key，则继续找当前结点的右子结点
             return get(x.right, key);
        } else if (cmp < 0) {
            // 如果新节点的key小于当前结点的key，则继续找当前结点的左子结点
             return get(x.left, key);
        } else {
            // 如果key等于x节点的key，就找到了键为key的结点
            return x.value;
        }

    }

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        // 子树不为空
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            // 如果新节点的key大于当前结点的key，则继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            // 如果新节点的key小于当前结点的key，则继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else {
            --N;

            // 如果key等于x结点的键，完成真正删除结点动作，要删除的节点就是x
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            // 得从右子树中找到一个最小的节点，来替换当前删除的结点
            Node minNode = x.right;
            while(minNode.left != null) {
                minNode = minNode.left;
            }

            // 删除右子树中最小的节点
            Node n = x.right;
            while(n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                    break;
                }
                // 变化n结点 即可
                n = n.left;
            }

            // 让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            minNode.right = x.right;
            // 让x结点的父结点指向minNode
            x = minNode;

        }


        return x;
    }


    /**
     * 查找二叉树中最小的键
     * @return
     */
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        }
        return x;
    }

    /**
     * 查找二叉树中最大的键
     * @return
     */
    public Key max() {
        return max(root).key;
    }

    public Node max(Node x) {
        // 判断x还有没有右子节点，如果有， 则继续向右查找， 如果没有，则x就是最大键所在的结点
        if (x.right != null) {
            return max(x.right);
        }

        return x;
    }


    /**
     * 使用前序遍历，获取整个树中的所有键
     * @return
     */
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    /**
     * 获取指定树key的所有键，并放到keys队列中
     * @param x
     * @param keys
     */
    public void preErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        // 把x结点的key放入到keys中，也就是跟节点
        keys.enqueue(x.key);

        // 递归遍历左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }

        // 递归遍历右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }


    }

    /**
     * 中序遍历
     * @return
     */
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    public void  midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        // 先递归，把左子树的键放到keys中
        if (x.left != null) {
            midErgodic(x.left, keys);
        }

        // 把当前节点x的键放到keys中
        keys.enqueue(x.key);

        // 在递归把右子树的键放到keys中
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }


    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }


    /**
     * 后续遍历 先访问左子树，在访问右子树，最后访问根结点
     * @param x
     * @param keys
     * @return
     */
    public void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        // 递归调用左子树
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }

        // 递归调用右子树
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }

        // 根节点
        keys.enqueue(x.key);

    }


    /**
     * 层序遍历
     * @return
     */
    public Queue<Key> layerErgodic() {
        // 定义两个队列，分别存储树中的键和树中的结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);

        while(nodes.size() > 0) {
            // 从队列中弹出一个节点，把key放入到keys中
            Node dequeue = nodes.dequeue();
            keys.enqueue(dequeue.key);
            if (dequeue.left != null) {
                nodes.enqueue(dequeue.left);
            }
            if (dequeue.right != null) {
                nodes.enqueue(dequeue.right);
            }
        }

        return keys;
    }


    /**
     * 最大深度问题
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }


    private int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }

        // x的最大深度
        int max = 0;
        // 左子树的最大深度
        int maxL = 0;
        // 右子树的最大深度
        int maxR = 0;
        // 计算左子树的最大深度
        if (x.left != null) {
            maxL = maxDepth(x.left);
        }
        // 计算右子树的最大深度
        if (x.right != null) {
            maxR = maxDepth(x.right);
        }
        max = maxL > maxR ? maxL+1 : maxR + 1;

        return max;
    }



}
