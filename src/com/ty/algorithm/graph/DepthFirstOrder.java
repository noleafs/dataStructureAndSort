package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Stack;

/**
 * 基于深度优先的顶点排序
 * @author tanyun
 * @description
 * @date 2021/11/5 20:14
 */
public class DepthFirstOrder {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 使用栈，存储顶点序列
     */
    private Stack<Integer> reversePost;

    /**
     * 创建一个顶点排序对象，生成顶点线性序列；
     * @param G
     */
    public DepthFirstOrder(Digraph G) {
        this.marked = new boolean[G.V()];
        reversePost = new Stack<>();

        for (int i = 0; i < G.V(); i++) {
            if (!this.marked[i]) {
                dfs(G, i);
            }
        }

    }

    /**
     * 基于深度优先搜索，生成顶点线性序列
     * @param G
     * @param v
     */
    private void dfs(Digraph G, int v) {
        // 表示当前v已经被搜索
        this.marked[v] = true;
        // 深度搜索顶点V
        for (Integer w : G.adj(v)) {
            if (!this.marked[w]) {
                dfs(G, w);
            }
        }
        // 让顶点v进栈
        reversePost.push(v);
    }


    /**
     * 获取顶点线性序列
     * @return
     */
    public Stack<Integer> reversePost() {
        return reversePost;
    }


}
