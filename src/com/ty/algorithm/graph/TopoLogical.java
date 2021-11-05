package com.ty.algorithm.graph;

import com.ty.algorithm.linear.Stack;


/**
 * 拓扑排序
 * @author tanyun
 * @description
 * @date 2021/11/5 20:57
 */
public class TopoLogical {

    private Stack<Integer> order;

    /**
     * 构造拓扑排序对象
     * @param G
     */
    public TopoLogical(Digraph G) {
        // 检测是否有环
        DirectedCycle cycle = new DirectedCycle(G);
        if(!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    /**
     * 判断图G中是否有环
     * @return
     */
    public boolean isCycle() {
        return order == null;
    }

    /**
     * 获取拓扑排序的所有顶点
     * @return
     */
    public Stack<Integer> order() {
        return order;
    }

}
