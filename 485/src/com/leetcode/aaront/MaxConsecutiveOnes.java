package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/2/24
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                max = max > sum ? max : sum;
                sum = 0;
            }
        }
        return max > sum ? max : sum;
    }
}
