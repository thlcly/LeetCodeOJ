package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/2/23
 */
public class NextGreaterElementII {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] greaterElements = new int[len];
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            if (j >= len) j = 0;
            for (; j != i; j++) {
                if (j >= len) {
                    j = -1;
                    continue;
                }
                if (nums[j] > nums[i]) {
                    greaterElements[i] = nums[j];
                    break;
                }
            }
            if (j == i) greaterElements[i] = -1;
        }
        return greaterElements;
    }
}
