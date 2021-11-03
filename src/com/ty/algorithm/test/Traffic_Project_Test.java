package com.ty.algorithm.test;

import com.ty.algorithm.uf.UF_Tree_Weighted;

import java.io.*;
import java.util.zip.InflaterInputStream;

/**
 * @author tanyun
 * @description
 * @date 2021/10/27 20:41
 */
public class Traffic_Project_Test {

    public static void main(String[] args) throws IOException {

        // 构建一个缓冲读取流
        InputStream inputStream = new FileInputStream(new File("E:\\java chucun\\数据结构\\algorihm\\src\\com\\ty\\algorithm\\traffic_project.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        // 获取城市数
        int totalNumberCity = Integer.parseInt(bufferedReader.readLine());
        UF_Tree_Weighted uf_tree_weighted = new UF_Tree_Weighted(totalNumberCity);
        // 修建了多少条道路
        int roadNumber = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < roadNumber; i++) {
            String line = bufferedReader.readLine();
            String[] str = line.split(" ");
            // 让两个城市想通
            uf_tree_weighted.union(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }

        // 换一种意思就是，在合并12次就只有一颗树了
        System.out.println("还需要修建" + (uf_tree_weighted.count()-1) + "条道路");

    }

}
