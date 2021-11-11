package com.ty.algorithm.test;

import com.ty.algorithm.graph.Edge;
import com.ty.algorithm.graph.EdgeWeightedGraph;
import com.ty.algorithm.graph.PrimMST;
import com.ty.algorithm.linear.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试使用Prim算法 计算最小生成树
 * @author tanyun
 * @description
 * @date 2021/11/11 20:26
 */
public class PrimMSTTest {

    public static void main(String[] args) throws IOException {
        // 1.准备加权无向图
        BufferedReader reader = new BufferedReader(new InputStreamReader(PrimMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));
        // 顶点数量
        int total = Integer.parseInt(reader.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(total);
        // 边的数量
        int totalEdge = Integer.parseInt(reader.readLine());
        for (int i = 0; i < totalEdge; i++) {
            // 构建边
            String[] s = reader.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            double q = Double.parseDouble(s[2]);
            Edge edge = new Edge(v, w, q);
            G.addEdge(edge);
        }

        // 2.创建一个PrimMst对象，计算加权无向图中的最小生成树
        PrimMST primMST = new PrimMST(G);

        Queue<Edge> edges = primMST.edges();
        for (Edge edge : edges) {
            int v = edge.either();
            int w = edge.other(v);
            System.out.println(v + "-" + w + "::" + edge.weight());
        }

    }
}
