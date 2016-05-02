package com.aaront.sorting.factory;

import com.aaront.sorting.algorithm.SelectionSortAlgorithm;
import com.aaront.sorting.algorithm.SortAlgorithm;

/**
 * @author tonyhui
 * @since 16/5/2
 */
public class SelectionSortAlgorithmFactory implements SortAlgorithmFactory {
    @Override
    public SortAlgorithm buildSortAlgorithm() {
        return new SelectionSortAlgorithm();
    }
}
