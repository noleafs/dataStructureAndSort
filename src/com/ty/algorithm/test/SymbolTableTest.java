package com.ty.algorithm.test;

import com.ty.algorithm.symbol.SymbolTable;

/**
 * @author tanyun
 * @description
 * @date 2021/8/3 22:11
 */
public class SymbolTableTest {

    public static void main(String[] args) {
        SymbolTable<String, String> symbolTable = new SymbolTable<>();
        symbolTable.put("1","one");
        symbolTable.put("2","two");
        symbolTable.put("3","three");
        symbolTable.put("4","fout");

        // 测试删除
        symbolTable.delete("2");
        symbolTable.put("1", "111");
        System.out.println(symbolTable.get("2"));
        System.out.println(symbolTable.get("1"));
        System.out.println("个数为：" + symbolTable.size());
    }

}
