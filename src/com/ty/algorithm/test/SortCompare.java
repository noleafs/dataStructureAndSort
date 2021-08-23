package com.ty.algorithm.test;

import com.ty.algorithm.sort.Merge;
import com.ty.algorithm.sort.Selection;
import com.ty.algorithm.sort.Shell;

import java.io.*;
import java.util.ArrayList;

/**
 * @author tanyun
 * @description
 * @date 2021/7/16 20:46
 */
public class SortCompare {

    /**
     * 调用不同的测试方法，完成测试
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 创建集合，保存读取出来的整数
        ArrayList<Integer> list = new ArrayList<>();
        // 创建缓存读取流BufferedReader
        String path = "E:\\java chucun\\数据结构\\algorihm\\src\\com\\ty\\algorithm\\reverse_arr.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String line = null;
        while((line = bufferedReader.readLine()) != null) {
            list.add(Integer.valueOf(line));
        }

        bufferedReader.close();

        // 将集合转成数组
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
//        testShell(arr);
//        testSelection(arr);
        testMerge(arr);
    }

    // 归并排序 大约花费50-150区间毫秒
    public static void testMerge(Integer[] a) {
        long startTime = System.currentTimeMillis();

        // 执行算法代码
        Merge.sort(a);

        // ----
        System.out.println("插入排序算法排序花费了： " + (System.currentTimeMillis() - startTime) );
    }


    // 测试希尔排序 大约会花费 三四十 毫秒
    public static void testShell(Integer[] a) {
        long startTime = System.currentTimeMillis();

        // 执行算法代码
        Shell.sort(a);

        System.out.println("希尔排序算法排序花费了： " + (System.currentTimeMillis() - startTime) );
    }


    // 测试插入排序 大约会花费 15778 毫秒
    public static void testSelection(Integer[] a) {
        long startTime = System.currentTimeMillis();

        // 执行算法代码
        Selection.sort(a);

        System.out.println("插入排序算法排序花费了： " + (System.currentTimeMillis() - startTime) );
    }


}
