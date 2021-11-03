package com.ty.algorithm.uf;

/**
 * @author tanyun
 * @description
 * @date 2021/9/17 20:12
 */
public class UF {

    // 记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;

    //记录并查集中数据的分组个数
    private int count;

    // 初始化并查集
    public UF(int N) {
        // 初始化分组的数量, 默认情况下，有N个分组
        this.count = N;

        // 初始化eleAndGrout数组
        eleAndGroup = new int[N];

        // 初始化eleAndGroup中的元素及其所在的组的标识符,让eleAndGroup数组的索引作为并查集的每个结点的元素，并且让每个索引处的值（该元素所在的组的标识符）为该索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            // i 就是标识符
            eleAndGroup[i] = i;
        }

    }

    /**
     * 获取当前并查集中的数据有多少个分组
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 元素p所在分组的标识符
     * @param p
     * @return
     */
    public int find(int p) {
        return eleAndGroup[p];
    }

    /**
     * 判断并查集中p元素和q元素是否在同一分组中
     * @param p
     * @param q
     * @return 在则返回true 反之false
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 把p元素所在分组和q元素所在分组合并
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        // 首先判断q和p元素是否在同一分组中，在的话则不需要进行何必
        if (connected(p,q)) {
            return;
        }

        // 获取p所在的分组
        int pGroup = eleAndGroup[p];
        // 获取p所在的分组
        int qGroup = eleAndGroup[q];
        // 将p所在分组的所有元素的组标识符变为q所在分组的标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }

        // 分组个数-1
        this.count--;

    }





}
