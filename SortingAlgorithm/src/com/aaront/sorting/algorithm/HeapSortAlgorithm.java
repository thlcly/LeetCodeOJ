package com.aaront.sorting.algorithm;

/**
 * @author tonyhui
 * @since 16/5/3
 */
public class HeapSortAlgorithm extends BaseAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        System.out.println("堆排序...");
        int len = array.length - 1;
        // 只有len/2-1 ~ 0的节点含有子节点
        for (int i = (len - 1) / 2; i >= 0; i--) {    // 初始化堆, 从下到上,从右到左进行构建 2*i+1>=len => i<=(len-1)/2
            heapAdjust(array, i, len);
        }

        while (len > 0) {
            swap(array, len--, 0);
            heapAdjust(array, 0, len);
        }
    }

    /**
     * 父节点和子节点的关系
     * (array[0]是第一个数据): parent:i, left: 2*i+1, right: 2*i+2
     * (array[1]是第一个数据): parent:i, left: 2*i,   right: 2*i+1
     *
     * @param array
     * @param node
     * @param len   数组最后一个数的下标
     */
    // 调整节点
    public void heapAdjust(int[] array, int node, int len) {
        int j; // 指针,用于指向左子节点和右子节点
        int left;
        while ((node * 2 + 1) <= len) { // 左子节点存在
            left = node * 2 + 1;
            j = left; // 指针指向左子节点
            if (left + 1 <= len && array[left] < array[left + 1]) j++;  //如果右子节点存在&&array[left] < array[right],指针指向右子节点
            if (array[node] < array[j]) swap(array, node, j);
            else break; // 如果父节点已经最大,则直接跳出,因为是从下到上,从右到左进行调整的,所以一个调整好的节点的所有子节点都是满足条件的
            node = j; // 因为可能j也是指向一个父节点,要继续进行调整
        }
    }

    private void swap(int[] array, int index1, int index2) {
        if (index1 != index2) {
            array[index1] = array[index1] ^ array[index2];
            array[index2] = array[index1] ^ array[index2];
            array[index1] = array[index1] ^ array[index2];
        }
    }


}
