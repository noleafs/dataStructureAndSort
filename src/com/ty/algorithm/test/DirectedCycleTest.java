package com.ty.algorithm.test;

import com.ty.algorithm.graph.Digraph;
import com.ty.algorithm.graph.DirectedCycle;

/**
 * @author tanyun
 * @description
 * @date 2021/11/4 22:12
 */
public class DirectedCycleTest {

    public static void main(String[] args) {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(3,0);
        digraph.addEdge(0,2);
        digraph.addEdge(2,1);
        digraph.addEdge(1, 4);
//        digraph.addEdge( 4,1);
        digraph.addEdge(1, 0);

        DirectedCycle directedCycle = new DirectedCycle(digraph);
        //检测是否有环
        System.out.println("是否存在环： " + directedCycle.hasCycle());
    }

}
