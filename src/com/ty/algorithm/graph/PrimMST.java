package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Queue;
import com.ty.algorithm.priority.IndexMinPriorityQueue;

import java.util.Arrays;

/**
 * PRIM算法实现最小生成树
 *
 * @author tanyun
 * @description
 * @date 2021/11/10 21:35
 */
public class PrimMST {
    /**
     * 索引代表顶点(目标顶点)，值表示当前顶点和最小生成树之间的最短边
     */
    private Edge[] edgeTo;

    /**
     * 索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
     */
    private double[] distTo;

    /**
     * 索引代表顶点，如果当前顶点在最小树中，则值为true，否则为false
     */
    private boolean[] marked;

    /**
     * 存放最小树集合和非树集合之间的有效横切边  key为非最小树集合顶点
     */
    private IndexMinPriorityQueue<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        // 创建一个和图的顶点数一样大小的Edge数组
        this.edgeTo = new Edge[G.V()];
        // 创建一个和图的顶点数一样大小的double数组，表示权重，并且初始化数组中的内容为无穷大，无穷大即表示不存在这样的边
        this.distTo = new double[G.V()];
        // 将distTo数组中每个元素填充为 第二个参数
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        // 创建一个和图的顶点数一样大小的boolean数组，表示当前顶点是否已经在最小树中
        this.marked = new boolean[G.V()];
        // 创建一个索引优先队列，存储有效横切边
        this.pq = new IndexMinPriorityQueue<>(G.V());
        // 默认让一个顶点进入最小树中
        pq.insert(0, 0.0);
        // 每次遍历获取到权重最小的横切边对应的顶点，并加入到最小生成树中
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    /**
     * 将顶点V添加到最小生成树中， 并且更新数据
     *
     * @param G
     * @param v 顶点
     * @return void
     * @Author tanyun
     * @Description
     * @Date 2021/11/10 22:27
     **/
    private void visit(EdgeWeightedGraph G, int v) {
        // 把v顶点添加到最小生成树中
        this.marked[v] = true;

        // G.adj(v) 相当于是获取到了集合的横切边
        for (Edge e : G.adj(v)) {
            // 边e的一个顶点是v，找到另外一个顶点w
            int w = e.other(v);
            // 首先判断横切边的顶点是否处于最小树中，如果在说明此顶点已经处理过了，开始下一次循环
            if (marked[w]) {
                continue;
            }

            //如果v-w边e的权重比目前distTo[w]权重小，则需要修正数据， 因为distTo中存储的是最小权重
            if (e.weight() < distTo[w]) {
                //把顶点w距离最小生成树的边修改为e
                edgeTo[w] = e;
                //把顶点w距离最小生成树的边的权重修改为e.weight()
                distTo[w] = e.weight();

                //存储横切边
                if (pq.contains(w)) {
                    //如果pq中存储的有效横切边已经包含了w顶点，则需要修正最小索引优先队列w索引关联的权重值
                    pq.changeite(w, e.weight());
                } else {
                    //如果pq中存储的有效横切边不包含w顶点，则需要向最小索引优先队列中添加v-w和其权重值
                    pq.insert(w, e.weight());
                }
            }

        }
    }


    /**
     * 获取最小生成树的所有边二位就能不会
     *
     *
     * @return
     */
    public Queue<Edge> edges() {
        //创建队列
        Queue<Edge> edges = new Queue<>();
        //遍历edgeTo数组，找到每一条边，添加到队列中
        for (int i = 0; i < marked.length; i++) {
            if (edgeTo[i] != null) {
                edges.enqueue(edgeTo[i]);
            }
        }
        return edges;
    }


}
