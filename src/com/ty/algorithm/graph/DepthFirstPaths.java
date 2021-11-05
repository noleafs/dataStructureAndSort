package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Stack;

/**
 * 无向图的 路劲查找
 * @author tanyun
 * @description
 * @date 2021/11/3 20:20
 */
public class DepthFirstPaths {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;

    /**
     * 起点
     */
    private int s;

    /**
     * 索引代表顶点，值代表从起点s到当前顶点路劲上的最后一个顶点
     */
    private int[] edgeTo;

    /**
     * 使用深度优先搜索找出G图中 起点为s的所有路径
     */
    public DepthFirstPaths(Graph G, int s) {
        // 初始化marked
        this.marked = new boolean[G.V()];
        // 初始化起点
        this.s = s;
        // 初始化路劲数组
        this.edgeTo = new int[G.V()];

        dfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相通顶点, 并记录路径
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        // 设置v为已搜索
        this.marked[v] = true;
        // 获取此节点的相邻节点
        for (Integer w : G.adj(v)) {
            // 深度优先，先从子开始
            if (!marked[w]) {
                // 记录是从哪一个顶点到达当前顶点的']
                this.edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 判断v顶点与起点s是否存在路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 找出从起点s到顶点v的路劲（就是该路劲经过的顶点）
     * @param v
     * @return
     */
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return new Stack<>();
        }

        // 创建栈对象，保存路劲中的所有顶点
        Stack<Integer> path = new Stack<>();


        for (int x=v; x!=s; x = edgeTo[x]) {
            path.push(x);
        }

        // 把起点s放到栈中
        path.push(s);

        return path;
    }


}
