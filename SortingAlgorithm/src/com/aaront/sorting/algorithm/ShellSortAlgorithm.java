package com.aaront.sorting.algorithm;

/**
 * @author tonyhui
 * @since 16/5/3
 */
public class ShellSortAlgorithm extends BaseAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        System.out.println("希尔排序...");
        int d = array.length / 2;
        while (d >= 1) {
            shellAlgorithm(array, d);
            d /= 2;
        }
    }

    /**
     * 希尔排序: O(n*1.3),
     * 是直接插入排序的进一步抽象,其将数据之间的间隔右固定的1抽象成d,因为对于基本有序的数列直接插入算法O(n),所以希尔排序的
     * 原理就是根据不同的步长将数列先排序成基本有序的,最后设置步长为1,对数列进行直接插入排序
     *
     * @param array
     * @param d     数据之间间隔的距离(对于直接插入排序来说,d恒为1)
     */
    public void shellAlgorithm(int[] array, int d) {
        for (int i = d, len = array.length; i < len; i++) {
            int j = i - d;
            int temp = array[i]; // 待排序的数据
            while (j >= 0 && array[j] > temp) {
                array[j + d] = array[j];
                j -= d;
            }
            array[j + d] = temp;
        }
    }
}
