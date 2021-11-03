package com.ty.algorithm.graph;

/**
 * 图搜索， 深度优先算法
 * @author tanyun
 * @description
 * @date 2021/10/29 21:08
 */
public class DepthFirstSearch {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;

    /**
     * 记录有多少个顶点与s顶点想通
     *      s 起点
     */
    private int count;

    /**
     * 构建深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相通顶点
     * @param G
     * @param v
     */
    public DepthFirstSearch(Graph G, int v) {
        // 初始化
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G, v);
    }

    /**
     * 使用深度优先搜索找出G图中V顶点的所有相通顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        // 把v顶点表示为已搜索
        this.marked[v] = true;
        for (Integer w : G.adj(v)) {
            // w相领顶点
            // 盘点当前w顶点是否被搜索过，如果没有被搜索过，则递归调用dfs方法进行深度搜索
            if (!marked[w]) {
                dfs(G, w);
            }
        }

        //与起点相通数++
        count++;
    }


    /**
     * 判断w顶点与s顶点是否想通
     * @param w
     * @return
     */
    public boolean marked(int w) {
        return marked[w];
    }


    /**
     * 获取与顶点s相通的所有顶点的总数
     * @return
     */
    public int count() {
        return count;
    }



}
