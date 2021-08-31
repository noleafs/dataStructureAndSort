package com.ty.algorithm.heap;

/**
 * 堆 排序
 * @author tanyun
 * @description
 * @date 2021/8/26 20:11
 */
public class HeapSort<T extends Comparable<T>> {

    /**
     * 判断heap堆中索引处i的元素是否小于索引j处的元素
     * @param heap
     * @param i
     * @param j
     * @return
     */
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换heap堆中i索引和j索引处的值
     * @param heap
     * @param i
     * @param j
     */
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 根据原数组source，构造出堆heap
     *      创建一个新数组，把原数组0~length-1的数据拷贝到新数组的1~length处，再从新数组长度的一半处开始往1索引处扫描（从右往左），然后
     *          对扫描到的每一个元素做下沉调整即可。
     * @param source
     * @param heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 1.把source中的元素拷贝到heap中，heap中的元素就形成一个堆，但是此时这个堆是无序的
        System.arraycopy(source, 0, heap, 1, source.length);

        // 2.对堆中的元素进行下沉调整(从长度的一半处开始，往索引1处扫描)
        for (int i = heap.length / 2; i > 0; i--) {
            sink(heap, i, heap.length-1);
        }
    }

    /**
     * 对source数组中的数据从小到大排序
     * @param source
     */
    public static void sort(Comparable[] source) {
        // 1.构建堆
        Comparable[] heap = new Comparable[source.length+1];
        createHeap(source,  heap);

        // 2.对堆进行排序
        for (int i = heap.length - 1; i > 0; i--) {
            // 交换元素
            exch(heap,1, i);
            // 排除交换后最大元素最大元素所在的索引，让它不要参与堆的下层调整
            sink(heap, 1,i-1);
        }

        // 把heap中的数据复制到原数组中
        System.arraycopy(heap, 1, source, 0, source.length);

    }

    /**
     * 在heap堆中，对target处的元素做下沉， 范围是0-range
     * @param heap
     * @param target
     * @param range 下层范围 target - range
     */
    private static void sink(Comparable[] heap, int target, int range) {
        while(target*2 <= range) {
            //1.找出当前结点的较大的子节点
            int max;
            if (target*2+1 <= range) {
                if (less(heap, 2*target, 2*target+1)) {
                    max = 2*target+1;
                } else {
                    max = 2*target;
                }
            } else {
                max = 2*target;
            }

            // 当前结点跟最大的子节点进行对比
            if (!less(heap, target, max)) {
                break;
            }

            exch(heap, target, max);
            target = max;
        }
    }


}
