package com.ty.algorithm.test;

import com.ty.algorithm.graph.DepthFirstPaths;
import com.ty.algorithm.graph.Graph;
import com.ty.algorithm.linear.Stack;

/**
 * 图的路径查询 测试
 * @author tanyun
 * @description
 * @date 2021/11/3 21:14
 */
public class DepthFirstPathsTest {

    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(0,2);
        G.addEdge(0,1);
        G.addEdge(2,1);
        G.addEdge(2,3);
        G.addEdge(2,4);
        G.addEdge(3,5);
        G.addEdge(3,4);
        G.addEdge(0,5);

        // 构建路劲查找，起点为0
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, 0);
        // 查找0到4顶点的路径
        Stack<Integer> stack = depthFirstPaths.pathTo(4);
        for (Integer s : stack) {
            System.out.print(s + "-");
        }
    }
}
