package com.aaront.sorting;

/**
 * @author tonyhui
 * @since 16/5/2
 */
public class QuickSortAlgorithm extends BaseAlgorithm{
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 2, 4, 3, 5, 7, 9, 5, 3, 5, 67, 8, 7, 5, 3, 2, 45, 6, 8, 9, 2};
        QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
        quickSortAlgorithm.quickAlgorithm(array, 0, array.length - 1);
        quickSortAlgorithm.print(array);
    }

    /**
     * 快速排序: O(nlgn)
     * 思路: 1. 选取一个基准数(通常是pivokey = array[left])
     *      2. 设定两个指针(i->left, j->right), 从j开始,
     *          如果(left < right && array[j] <= pivokey) => j--,
     *          如果(left < right && array[i] > pivokey) => i++;
     *      3. 最后array[left] = pivokey;
     *      4. 递归调用
     *      5. 递归结束判断条件: left > right
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int parition(int[] array, int left, int right) {
        int pivotKey = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivotKey)
                right--;
            array[left] = array[right];
            while (left < right && array[left] < pivotKey)
                left++;
            array[right] = array[left];
        }
        array[left] = pivotKey; // 进行先后覆盖,因为最开始的值已经保存在pivoKey中
        return left;
    }

    public void quickAlgorithm(int[] array, int left, int right) {
        if(left > right) return;    // 递归终止条件
        int paritionPos = parition(array, left, right);
        quickAlgorithm(array, left, paritionPos - 1);   // paritionPos将数组一分为二, 递归调用
        quickAlgorithm(array, paritionPos + 1, right);
    }
}
