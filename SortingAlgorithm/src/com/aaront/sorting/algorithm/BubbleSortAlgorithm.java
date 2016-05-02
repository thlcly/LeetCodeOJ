package com.aaront.sorting.algorithm;

/**
 * @author tonyhui
 * @since 16/5/1
 */
public class BubbleSortAlgorithm extends BaseAlgorithm implements SortAlgorithm{
    @Override
    public void sort(int[] array) {
        System.out.println("冒泡排序...");
        bubbleSort(array);
    }

    /**
     * 冒泡算法: O(n)
     * 思路: outer循环每遍历一次就产生一个未排序的数中的最大值
     * @param array
     */
    public void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] ^ array[j+1];
                    array[j+1] = array[j] ^ array[j+1];
                    array[j] = array[j] ^ array[j+1];
                }
            }
        }
    }
}
