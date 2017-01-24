package com.aaront.leetcode;

/**
 * @author tonyhui
 * @since 17/1/24
 */
public class TargetSum {

    int result = 0;

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        targetSum.findTargetSumWays(0, 0, nums, 3);
        System.out.println(targetSum.result);
    }

    /**
     * 思路: 实际上就是遍历运算符的所有的组合, 因此可以使用深度遍历来完成
     */
    public void findTargetSumWays(int sum, int cnt, int[] nums, int S) {
        if (cnt == nums.length) {
            if (sum == S) result++;
            return;
        }

        findTargetSumWays(sum + nums[cnt], cnt + 1, nums, S);
        findTargetSumWays(sum - nums[cnt], cnt + 1, nums, S);
    }
}
