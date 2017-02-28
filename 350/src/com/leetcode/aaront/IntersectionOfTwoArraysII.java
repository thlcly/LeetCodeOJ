package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tonyhui
 * @since 17/2/28
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        System.out.println(Arrays.toString(i.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(i.intersect(new int[]{1, 2}, new int[]{1, 1})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0, len = nums2.length; i < len; i++) {
            int index = binarySearch(nums1, nums2[i]);
            if (index != -1) {
                result.add(nums2[i]);
                nums1 = delete(nums1, index);
            }
        }
        return result.stream().mapToInt(r -> r).toArray();
    }

    public int binarySearch(int[] arraySorted, int num) {
        int low = 0;
        int high = arraySorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arraySorted[mid] == num) return mid;
            if (arraySorted[mid] > num) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public int[] delete(int[] array, int index) {
        for (int i = index, len = array.length; i < len - 1; i++) {
            array[i] = array[i + 1];
        }
        return Arrays.copyOfRange(array, 0, array.length - 1);
    }

}
