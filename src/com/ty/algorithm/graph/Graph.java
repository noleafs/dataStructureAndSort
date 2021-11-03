package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Queue;

/**
 * 图 使用链接表实现 无向图
 * @author tanyun
 * @description
 * @date 2021/10/29 20:19
 */
public class Graph {

    /**
     * 顶点数目
     */
    private final int v;
    /**
     * 边的数目
     */
    private int E;
    /**
     * 邻接表
     */
    private Queue<Integer>[] adj;

    public Graph(int v) {
        // 初始化顶点数量
        this.v = v;
        // 初始化边的数量
        this.E = 0;
        // 初始化顶点
        this.adj = new Queue[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Queue<>();
        }
    }

    /**
     * 获取顶点的数目
     * @return
     */
    public int V() {
        return this.v;
    }

    /**
     * 获取边的数目
     * @return
     */
    public int E() {
        return this.E;
    }

    /**
     * 向图中添加一条边 v-w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        // 在无向图中边是没有方向的
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        // 边的数量+1
        E++;
    }

    /**
     * v顶点相领的顶点
     * @param v
     * @return
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }



}
