package com.ty.algorithm.test;

import com.ty.algorithm.graph.BreadthFirstSearch;
import com.ty.algorithm.graph.DepthFirstSearch;
import com.ty.algorithm.graph.Graph;

/**
 * @author tanyun
 * @description
 * @date 2021/10/29 21:32
 */
public class BreadthFirstSearchTest {

    public static void main(String[] args) {
        // 准备图 此图中有三个不相通子图
        Graph g = new Graph(13);
        g.addEdge(0,6);
        g.addEdge(0,2);
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(5,3);
        g.addEdge(5,4);
        g.addEdge(4,3);
        g.addEdge(6,4);

        g.addEdge(7,8);

        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(12,11);
        g.addEdge(12,9);

        // 深度优先搜索
        BreadthFirstSearch search = new BreadthFirstSearch(g, 0);

        // 测试相通数量
        System.out.println("与起点0相通数量： "+ search.count());
        System.out.println("顶点7与顶点0是否相通：" + search.marked(7));

        System.out.println("-------------------------------------------");
        search = new BreadthFirstSearch(g, 7);
//        // 测试相通数量
        System.out.println("与起点7相通数量： "+ search.count());



    }
}
