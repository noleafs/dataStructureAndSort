package com.ty.algorithm.graph;

/**
 * 检测有向图中是否有环
 * @author tanyun
 * @description
 * @date 2021/11/4 21:14
 */
public class DirectedCycle {

    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 记录图中是否有环
     */
    private boolean hasCycle;
    /**
     * 索引代表顶点，记录当前顶点有没有处于正在搜索的有向路径上
     */
    private boolean[] onStack;


    /**
     * 创建一个检测环对象，检测图G中是否有环
     */
    public DirectedCycle(Digraph G) {
        this.marked = new boolean[G.V()];
        this.hasCycle = false;
        this.onStack = new boolean[G.V()];

        // 应该以每一个顶点为起点来检测是否有环，因为一个图中可能会存在多个非连通子图
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i])  {
                dfs(G, i);
                if (hasCycle) {
                    return;
                }
            }
        }

    }

    /**
     * 基于深度优先搜索，检测图G中是否有环
     * @param G
     * @param v
     */
    private void dfs(Digraph G, int v) {
        // 设置v为已搜索
        this.marked[v] = true;
        // 设置v为本次正在搜索的有向路径上
        this.onStack[v] = true;

        // 使用深度优先搜索
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
            // 当前顶点w是否已经在本次搜索路径中，如果在说明检测到环了
            if (onStack[w]) {
                this.hasCycle = true;
                return;
            }
        }

        this.onStack[v] = false;
    }

    /**
     * 判断图中是否有环
     * @return
     */
    public boolean hasCycle() {
        return hasCycle;
    }

}
