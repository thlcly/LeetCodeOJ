package com.aaront.sorting.test;

import com.aaront.sorting.algorithm.SortAlgorithm;
import com.aaront.sorting.factory.*;

/**
 * @author tonyhui
 * @since 16/5/2
 */
public class TestSortAlgorithm {
    public static void main(String[] args){
        int[] testArray = new int[]{2, 3, 2, 4, 3, 5, 7, 9, 5, 3, 5, 67, 8, 7, 5, 3, 2, 45, 6, 8, 9, 2};


        SortAlgorithmFactory sortAlgorithmFactory = null;
        SortAlgorithm sortAlgorithm = null;

        // 冒泡排序
        sortAlgorithmFactory = new BubbleSortAlgorithmFactory();
        sortAlgorithm = sortAlgorithmFactory.buildSortAlgorithm();
        sortAlgorithm.sort(testArray);
        sortAlgorithm.print(testArray);

        // 选择排序
        sortAlgorithmFactory = new SelectionSortAlgorithmFactory();
        sortAlgorithm = sortAlgorithmFactory.buildSortAlgorithm();
        sortAlgorithm.sort(testArray);
        sortAlgorithm.print(testArray);

        // 插入排序
        sortAlgorithmFactory = new InsertionSortAlgorithmFactory();
        sortAlgorithm = sortAlgorithmFactory.buildSortAlgorithm();
        sortAlgorithm.sort(testArray);
        sortAlgorithm.print(testArray);

        // 快速排序
        sortAlgorithmFactory = new QuickSortAlgorithmFactory();
        sortAlgorithm = sortAlgorithmFactory.buildSortAlgorithm();
        sortAlgorithm.sort(testArray);
        sortAlgorithm.print(testArray);
    }
}
