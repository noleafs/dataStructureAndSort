package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Queue;

/**
 * 加权无向图
 *
 * @author tanyun
 * @description
 * @date 2021/11/8 21:00
 */
public class EdgeWeightedGraph {

    /**
     * 顶点数量
     **/
    private final int V;
    /**
     * 边的总数
     */
    private int E;
    /**
     * 邻接表
     */
    private Queue<Edge>[] adj;

    /**
     * 构建一个含有v个顶点的加权无向图
     *
     * @param v
     */
    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new Queue<>();
        }
    }

    /**
     * 获取图中顶点的数量
     *
     * @param
     * @return int
     * @Author tanyun
     * @Description
     * @Date 2021/11/8 21:42
     **/
    public int V() {
        return V;
    }

    /**
     * 获取图中边的数量
     *
     * @param
     * @return int
     * @Author tanyun
     * @Description
     * @Date 2021/11/8 21:42
     **/
    public int E() {
        return E;
    }

    /**
     * 向加权无向图中添加一条边e
     *
     * @param e
     * @return void
     * @Author tanyun
     * @Description
     * @Date 2021/11/8 21:41
     **/
    public void addEdge(Edge e) {
        // 因为是无向图所有两边都需要关联
        int v = e.either();
        int w = e.other(v);
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        E++;
    }

    /**
     * 获取和顶点v关联的所有边
     *
     * @param v
     * @return com.ty.algorithm.linear.Queue<com.ty.algorithm.graph.Edge>
     * @Author tanyun
     * @Description
     * @Date 2021/11/8 21:41
     **/
    public Queue<Edge> adj(int v) {
        return adj[v];
    }


    /**
     * 获取加权无向图的所有边
     *
     * @param
     * @return com.ty.algorithm.linear.Queue
     * @Author tanyun
     * @Description
     * @Date 2021/11/8 21:41
     **/
    public Queue<Edge> edges() {
        Queue<Edge> queue = new Queue<>();
        for (int i = 0; i < V; i++) {
            // 获取每个端点的领接表
            for (Edge edge : adj[i]) {
             /*
                因为无向图中，每条边对象Edge都会在两个顶点的邻接表中各出现一次，为了不重复获取，暂定
                一条规则：
                    除了当前顶点i，再获取边e中的另外一个顶点w，如果i < w则添加，这样可以保证同一条边只会被统计一次
             */
                if (edge.other(i) > i) {
                    queue.enqueue(edge);
                }
            }
        }

        return queue;
    }


}
