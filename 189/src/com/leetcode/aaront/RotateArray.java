package com.leetcode.aaront;

import java.util.Arrays;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class RotateArray {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 效率较低,不能ac
     *
     * @param nums
     * @param k
     */

    public static void rotate(int[] nums, int k) {
        int step = k % (nums.length);
        for (int i = 0; i < step; i++) {
            int temp = nums[nums.length - 1];
            move(nums);
            nums[0] = temp;
        }

    }

    public static void move(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
    }

    /**
     * 高效方法 O(n)
     * 思路:
     * 1 2 3 4 5 6 7 8 9 10 / 4
     * step 1: 10 9 8 7 6 5 4 3 2 1
     * step 2: 7 8 9 10 6 5 4 3 2 1
     * step 3: 7 8 9 10 1 2 3 4 5 6
     * ooh amazing ! it is perfect algorithm
     */

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);  // reverse the whole array
        reverse(nums, 0, k - 1);  // reverse the first part
        reverse(nums, k, nums.length - 1);  // reverse the second part
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
