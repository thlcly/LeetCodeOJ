package com.leetcode.aaront;

import java.util.Arrays;

/**
 * @author tonyhui
 * @since 17/2/24
 */
public class RelativeRanks {
    public static void main(String[] args) {
        RelativeRanks rr = new RelativeRanks();
        System.out.println(Arrays.toString(rr.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] rank = new String[nums.length];
        int max = findMax(nums);
        rank[max] = "Gold Medal";
        for (int i = 1, len = nums.length; i < len; i++) {
            max = findPos(nums, nums[max]);
            if (i == 1) rank[max] = "Silver Medal";
            else if (i == 2) rank[max] = "Bronze Medal";
            else rank[max] = (i + 1) + "";
        }
        return rank;
    }

    public int findPos(int[] array, int num) {
        int max = findMin(array);
        for (int i = 0, len = array.length; i < len; i++) {
            if (array[max] < array[i] && array[i] < num) {
                max = i;
            }
        }
        return max;
    }

    public int findMax(int[] nums) {
        int max = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        return max;
    }

    public int findMin(int[] nums) {
        int min = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] < nums[min]) min = i;
        }
        return min;
    }
}
