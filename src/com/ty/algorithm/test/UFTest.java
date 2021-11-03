package com.ty.algorithm.test;

import com.ty.algorithm.uf.UF;

/**
 * 测试并查集
 * @author tanyun
 * @description
 * @date 2021/9/17 20:46
 */
public class UFTest {
    public static void main(String[] args) {
        UF uf = new UF(10);

        System.out.println("1元素和3元素是否在同一分组： " + uf.connected(1,3));

        System.out.println("分组个数： " + uf.count());
        // 合并分组
        uf.union(1,3);
        System.out.println("合并后分组个数： " + uf.count());

        System.out.println("合并后1元素和3元素是否在同一分组： " + uf.connected(1,3));

    }
}
