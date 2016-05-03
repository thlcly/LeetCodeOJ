package com.aaront.sorting.factory;

import com.aaront.sorting.algorithm.ShellSortAlgorithm;
import com.aaront.sorting.algorithm.SortAlgorithm;

/**
 * @author tonyhui
 * @since 16/5/3
 */
public class ShellSortAlgorithmFactory implements SortAlgorithmFactory {
    @Override
    public SortAlgorithm buildSortAlgorithm() {
        return new ShellSortAlgorithm();
    }
}
