package com.ty.algorithm.graph;


import com.ty.algorithm.linear.Queue;

/**
 * 图搜索， 广度优先算法
 * @author tanyun
 * @description
 * @date 2021/11/2 20:05
 */
public class BreadthFirstSearch {

    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索过
     */
    private boolean[] marked;
    /**
     * 记录有多少个顶点与s顶点相通
     */
    private int count;
    /**
     * 用来存储待搜索领接表的顶点
     */
    private Queue<Integer> waitSearch;

    public BreadthFirstSearch(Graph g, int s) {
        this.marked = new boolean[g.V()];
        // 初始化队列
        this.waitSearch = new Queue<>();
        this.count = 0;

        dfs(g, s);
    }

    /**
     * 使用广度优先搜索找出G图中V顶点的所有相通顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        waitSearch.enqueue(v);

        while(true) {
            // 待搜索的顶点
            Integer i = waitSearch.dequeue();
            if (i == null) {
                break;
            }

            // 遍历i顶点的领接表
            for (Integer w : G.adj(i)) {
                if (!marked[w]) {
                    waitSearch.enqueue(w);
                    // 顶点数++
                    count++;
                    marked[w] = true;
                }
            }

        }

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
