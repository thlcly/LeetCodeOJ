package com.aaront.sorting;

import java.util.Arrays;

/**
 * @author tonyhui
 * @since 16/5/1
 */
public class SelectionSortAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 2, 4, 3, 5, 7, 9, 5, 3, 5, 67, 8, 7, 5, 3, 2, 45, 6, 8, 9, 2};
        SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();
        selectionSortAlgorithm.selectionAlgorithm(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序: O(n)
     * 思路: 每一次比较都选出未排序的数中的最大值并将其与未排序的数中的最后一个进行交换
     * 注意点: 如果使用位运算进行两个数的交换则要判断这两个数是否是同一个数(下表是否相同),如果相同则不能使用位运算,原因如下:
     * a=b=2; (a,b是同一个数(下标相同))
     * a = a ^ b (a=>0, b=>0)
     * b = a ^ b (a=>0, b=>0)
     * a = a ^ b (a=>0, b=>0)
     * @param array
     */
    public void selectionAlgorithm(int[] array) {
        int len = array.length;
        // 每一次比较都选出未排序的数中的最大值并将其与未排序的数中的最后一个进行交换
        // 最后一次不用进行比较
        for (int i = 0; i < len - 1; i++) {
            int max = 0;
            for (int j = 0; j < len - i; j++) {
                if(array[max] < array[j]) max = j;
            }
            // 位运算交换两个数的值 使用临时变量进行交换不需要判断是不是同一个数
//            int temp = array[max];
//            array[max] = array[len - 1 - i];
//            array[len - 1 - i] = temp;
            if(max == len - 1 - i) continue; // 如果使用位运算进行交换则要判断交换的两个数是不是同一个数(索引是否相同)如果相同则不能使用,因为会变成0
            array[max] = array[max] ^ array[len - 1 - i];
            array[len - 1 - i] = array[max] ^ array[len - 1 -i];
            array[max] = array[max] ^ array[len - 1 - i];
        }
    }
}
