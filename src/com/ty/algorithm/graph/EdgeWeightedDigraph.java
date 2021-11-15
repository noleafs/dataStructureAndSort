package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Queue;

/**
 * 加权有向图
 * @author tanyun
 * @description
 * @date 2021/11/12 21:36
 */
public class EdgeWeightedDigraph {

    /**
     * 顶点数量
     */
    private final int v;

    /**
     * 边数量
     */
    private int E;

    /**
     * 领接表, 索引为顶点
     */
    private Queue<DirectedEdge>[] adj;


    /**
     * 创建v个顶点的加权有向图
     * @param v 顶点数量
     */
    public EdgeWeightedDigraph(int v) {
        this.v = v;
        this.E = 0;
        this.adj = new Queue[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    /**
     * 向加权有向图中添加一条边
     */
    public void addEdge(DirectedEdge e) {
        // 起点
        int from = e.from();
        adj[from].enqueue(e);
        // 边数量++
        E++;
    }

    /**
     * 获取顶点v指向的所有边
     * @param v
     * @return
     */
    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权有向图的所有边
     * @return
     */
    public Queue<DirectedEdge> edges() {
        Queue<DirectedEdge> allEdge = new Queue<>();

        for (Queue<DirectedEdge> e : adj) {
            for (DirectedEdge directedEdge : e) {
                allEdge.enqueue(directedEdge);
            }
        }

        return allEdge;
    }

    /**
     * 获取顶点数量
     * @return
     */
    public int V() {
        return v;
    }

    /**
     * 获取边的数量
     * @return
     */
    public int E() {
        return E;
    }


}
