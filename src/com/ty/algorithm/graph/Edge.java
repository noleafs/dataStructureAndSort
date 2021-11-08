package com.ty.algorithm.graph;

/**
 * 描述权重边
 * @author tanyun
 * @description
 * @date 2021/11/8 20:38
 */
public class Edge implements Comparable<Edge> {

    /**
     * 顶点一
     */
    private final int v;

    /**
     * 顶点二
     */
    private final int w;

    /**
     * 当前边的权重
     */
    private final double weight;

    /**
     * 通过顶点v和顶点w以及权重weight值构造一个边对象
     * @param v
     * @param w
     * @param weight
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取当前边的权重
     * @return
     */
    public double weight() {
        return weight;
    }

    /**
     * 获取边上的一个点
     * @return
     */
    public int either() {
        return v;
    }

    /**
     * 假设 v = 2 w = 1
     * 获取边上除了顶点vertex外的另外一个顶点
     * @param vertex
     * @return
     */
    public int other(int vertex) {

        return vertex == v ? w : v;
    }


    @Override
    public int compareTo(Edge o) {
        int cmp = 0;
        if (o.weight > this.weight) {
           cmp = -1;
        } else if (o.weight < this.weight){
           // 如果当前边的权重值大，则让cmp = 1；
            cmp = 1;
        }
        return cmp;
    }


}
