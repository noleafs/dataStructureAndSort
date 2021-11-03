package com.ty.algorithm.test;

import com.ty.algorithm.graph.DepthFirstSearch;
import com.ty.algorithm.graph.Graph;
import com.ty.algorithm.uf.UF_Tree_Weighted;

import java.io.*;

/**
 * @author tanyun
 * @description
 * @date 2021/11/2 21:27
 */
public class Traffic_Project_Test2 {
    public static void main(String[] args) throws IOException {
        // 构建一个缓冲读取流
        InputStream inputStream = new FileInputStream(new File("E:\\java chucun\\数据结构\\algorihm\\src\\com\\ty\\algorithm\\traffic_project.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        // 获取城市数
        int totalNumberCity = Integer.parseInt(bufferedReader.readLine());
        Graph graph = new Graph(totalNumberCity);
        // 修建了多少条道路
        int roadNumber = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < roadNumber; i++) {
            String[] g = bufferedReader.readLine().split(" ");
            // 添加边， 代表相通的城市
            graph.addEdge(Integer.valueOf(g[0]), Integer.valueOf(g[1]));
        }


        // 使用深度优先搜索
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 9);
        // 判断8顶点和10顶点是否与9顶点相通
        System.out.println("8顶点与9顶点是否相通: " + depthFirstSearch.marked(8));
        System.out.println("10顶点是否与9顶点相通: " + depthFirstSearch.marked(10));

        bufferedReader.close();
        inputStream.close();
    }
}
