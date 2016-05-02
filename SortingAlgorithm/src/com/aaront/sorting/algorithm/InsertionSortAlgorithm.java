package com.aaront.sorting.algorithm;

/**
 * @author tonyhui
 * @since 16/5/1
 */
public class InsertionSortAlgorithm extends BaseAlgorithm implements SortAlgorithm{
    @Override
    public void sort(int[] array) {
        System.out.println("插入排序...");
        insertionAlgorithm(array);
    }

    /**
     * 插入排序: O(n)
     * 思路: 从n = 1开始,将数组分为已排序和未排序两部分,从未排序的数组中拿出第一个数(key)在已排序的数组中找到位置插入该数据
     * 找位置的方法: 从已排序的数组最后一位(j - 1)开始向前遍历,如果key < 当前数据,则将当前数据向后移动一位(array[j+1]=array[j];j--)
     * 直到找到合适的位置 || j<0,将待排序的数据插入到array[j+1]的位置
     *
     * @param array
     */
    public void insertionAlgorithm(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
