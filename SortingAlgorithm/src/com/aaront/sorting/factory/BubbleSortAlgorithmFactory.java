package com.aaront.sorting.factory;

import com.aaront.sorting.algorithm.BubbleSortAlgorithm;
import com.aaront.sorting.algorithm.SortAlgorithm;

/**
 * @author tonyhui
 * @since 16/5/2
 */
public class BubbleSortAlgorithmFactory implements SortAlgorithmFactory {
    @Override
    public SortAlgorithm buildSortAlgorithm() {
        return new BubbleSortAlgorithm();
    }
}
