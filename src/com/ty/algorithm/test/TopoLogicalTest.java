package com.ty.algorithm.test;

import com.ty.algorithm.graph.Digraph;
import com.ty.algorithm.graph.TopoLogical;
import com.ty.algorithm.linear.Stack;

/**
 * 拓扑排序测试
 * @author tanyun
 * @description
 * @date 2021/11/5 21:23
 */
public class TopoLogicalTest {

    public static void main(String[] args) {
        // 准备有向图
        Digraph g = new Digraph(6);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(1,3);
        // 通过拓扑排序对顶点进行排序
        TopoLogical topoLogical = new TopoLogical(g);
        // 将线性序列进行打印
        Stack<Integer> order = topoLogical.order();
        for (Integer i : order) {
            System.out.println(i);
        }
    }
}
