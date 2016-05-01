package com.aaront.sorting;

import java.util.Arrays;

/**
 * @author tonyhui
 * @since 16/5/1
 */
public class BubbleSortAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 2, 4, 3, 5, 7, 9, 5, 3, 5, 67, 8, 7, 5, 3, 2, 45, 6, 8, 9, 2};
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        bubbleSortAlgorithm.bubbleSort(array);
        System.out.println(Arrays.toString(array));
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
