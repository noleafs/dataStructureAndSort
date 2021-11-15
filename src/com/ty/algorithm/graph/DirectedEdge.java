package com.ty.algorithm.graph;

/**
 * 加权有向边
 * @author tanyun
 * @description
 * @date 2021/11/12 21:28
 */
public class DirectedEdge {
    /**
     * 起点
     */
    private final int v;

    /**
     * 终点
     */
    private final int w;

    /**
     * 边的权重
     */
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取有向边的起点
     * @return
     */
    public int from() {
        return v;
    }

    /**
     * 获取有向边的终点
     * @return
     */
    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }


}
