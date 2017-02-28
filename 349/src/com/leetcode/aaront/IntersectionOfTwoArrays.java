package com.leetcode.aaront;

import java.util.*;

/**
 * @author tonyhui
 * @since 17/2/28
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        List<Integer> intersection = new ArrayList<>();
        for(Integer ele : set1) {
            if(set2.contains(ele)) intersection.add(ele);
        }
        Integer[] integers = intersection.toArray(new Integer[0]);
        int[] intArray = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        return intArray;
    }
}
