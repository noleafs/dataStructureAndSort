package com.ty.algorithm.test;

import com.ty.algorithm.symbol.OrderSymbolTable;
import com.ty.algorithm.symbol.SymbolTable;

/**
 * @author tanyun
 * @description
 * @date 2021/8/3 22:11
 */
public class OrderSymbolTableTest {

    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> symbolTable = new OrderSymbolTable<>();
        symbolTable.put(1,"one");
        symbolTable.put(3,"three");
        symbolTable.put(2,"two");
        symbolTable.put(5,"fout");
        symbolTable.put(4, "111");



        for (String s : symbolTable) {
            System.out.println(s);
        }
    }

}
