package com.aaront.sorting.factory;

import com.aaront.sorting.algorithm.SortAlgorithm;

/**
 * @author tonyhui
 * @since 16/5/2
 */
public interface SortAlgorithmFactory {
    SortAlgorithm buildSortAlgorithm();
}
