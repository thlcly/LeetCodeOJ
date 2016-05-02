package com.aaront.sorting.factory;

import com.aaront.sorting.algorithm.InsertionSortAlgorithm;
import com.aaront.sorting.algorithm.SortAlgorithm;

/**
 * @author tonyhui
 * @since 16/5/2
 */
public class InsertionSortAlgorithmFactory implements SortAlgorithmFactory {
    @Override
    public SortAlgorithm buildSortAlgorithm() {
        return new InsertionSortAlgorithm();
    }
}
