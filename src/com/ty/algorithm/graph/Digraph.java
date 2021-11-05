package com.ty.algorithm.graph;
import com.ty.algorithm.linear.Queue;

/**
 * 有向图
 * @author tanyun
 * @description
 * @date 2021/11/4 20:28
 */
public class Digraph {

    /**
     * 顶点数量
     */
    private final int V;
    /**
     * 边的数量
     */
    private int E;
    /**
     * 邻接表
     */
    private Queue<Integer>[] adj;

    public Digraph(int v) {
        this.V = v;
        this.E = 0;
        // 初始化领接表
        this.adj = new Queue[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new Queue<>();
        }
    }

    /**
     * 获取图中顶点的数量
     * @return
     */
    public int V(){
        return V;
    }

    /**
     * 获取图中边的数量
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * 向有向图中添加一条边 v -> w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        this.adj[v].enqueue(w);
        E++;
    }

    /**
     * 获取由v顶点指向的所有邻接顶点
     * @param v
     * @return
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 该图的反向图
     * @return
     */
    private Digraph reverse() {
        Digraph digraph = new Digraph(V);

        for (int i = 0; i < V; i++) {
            for (Integer w : this.adj[i]) {
                // 得到原图中的i顶点对应的邻接表,原图中的边为 i->w,则反向图中边为w->i;
                digraph.adj[w].enqueue(i);
            }

        }

        return digraph;
    }

}

