package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Queue;
import com.ty.algorithm.priority.MinPriorityQueue;
import com.ty.algorithm.uf.UF_Tree_Weighted;

/**
 * kruskal 算法 计算最小生成树
 * @author tanyun
 * @description
 * @date 2021/11/11 21:55
 */
public class KruskalMST {
    /**
     * 保存最小生成树的所有边
     */
    private Queue<Edge> mst;

    /**
     * 底层是数组实现，索引代表顶点，使用uf.connect(v,w) 可以判断顶点v和顶点w是否在同一棵树中， 使用uf.union(v,w) 可以把顶点v所在的树和顶点w所在的树合并
     */
    private UF_Tree_Weighted uf;

    /**
     * 存储图中所有的边，使用最小优先队列，按照权重进行排序
     */
    private MinPriorityQueue<Edge> pq;


    /**
     * 根据加权无向图，创建最小生成树
     * @param G
     */
    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        uf = new UF_Tree_Weighted(G.V());
        pq = new MinPriorityQueue<>(G.E());

        //把无向图中所有的边，放入到pq中
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        // 遍历pq队列，每次拿到权重最小的边，进行处理
        // 最小生成树的边的数量是顶点数量-1
        while (!pq.isEmpty() && mst.size() < G.V()-1) {
            // 获取到权重最小的边
            Edge e = pq.delMin();
            // 找到该边的两个顶点
            int v = e.either();
            int w = e.other(v);
            // 判断这两个顶点是否在同一颗树中，如果在同一颗树，则不对该边进行处理，不在则让这两个顶点所属的树合并为一颗树
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);

            // 那么该边就是最小生成树的一条边
            mst.enqueue(e);
        }

    }

    /**
     *  获取最小生成树的所有边
     * @Author tanyun
     * @Description
     * @Date 2021/11/11 22:18
     * @return
     **/
    public Queue<Edge> edges() {
        return this.mst;
    }

}
