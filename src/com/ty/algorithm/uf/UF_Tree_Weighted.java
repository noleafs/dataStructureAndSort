package com.ty.algorithm.uf;

/**
 * 并查集最终优化版, 主要是优化find方法， 让树的深度变低
 * @author tanyun
 * @description
 * @date 2021/10/25 21:34
 */
public class UF_Tree_Weighted {


    // 记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    /**
     * 记录每个根节点中有多少结点
     */
    private int[] sz;

    //记录并查集中数据的分组个数
    private int count;

    // 初始化并查集
    public UF_Tree_Weighted(int N) {
        // 初始化分组的数量, 默认情况下，有N个分组，每个分组都是一个根节点
        this.count = N;

        // 初始化eleAndGrout数组
        eleAndGroup = new int[N];

        // 初始化eleAndGroup中的元素及其所在的组的标识符,让eleAndGroup数组的索引作为并查集的每个结点的元素，此时数组里的值不再是分组标识了，而是该结点的父结点
        for (int i = 0; i < eleAndGroup.length; i++) {
            // i 就是标识符
            eleAndGroup[i] = i;
        }

        sz = new int[N];
        // 默认情况下，每个根节点只有一个节点
        for (int i = 0; i < sz.length; i++) {
            // i 就是标识符
            this.sz[i] = 1;
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
     * 元素p所在树的根节点
     * @param p
     * @return
     */
    public int find(int p) {
        while (eleAndGroup[p] != p) {
            p = eleAndGroup[p];
        }

        return p;
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
        // 找到p元素和q元素所在组对应的根节点
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        // 让p所在树的根节点的父结点为q所在树的根节点即可
        int pRootSize = sz[pRoot];
        int qRootSize = sz[qRoot];

        // 判断哪个树比较大，把小的那个树合并到大的树上
        if (pRootSize < qRootSize) {
            this.eleAndGroup[pRoot] = qRoot;
            // 结点数量需要加
            sz[qRoot] = qRootSize+pRootSize;
        } else {
            this.eleAndGroup[qRoot] = pRoot;
            sz[pRoot] = qRootSize+pRootSize;
        }

        this.count--;
    }


}
