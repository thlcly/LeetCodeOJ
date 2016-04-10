package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/10
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{2,2}));
    }

    /**
     * 思路: (1) 记以第i个数为结尾的最长路径为d(i)
     *
     *      因此可以得出状态转移方程 d(i) = max{0, d(j)} + 1, 其中j < i & A[j] < A[i]
     *      表示: 以第i个数为结尾的最长路径是前i个数且值小于A[i]的最长路径集合中的最大值 + 1
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int MAX = 0;
        int[] steps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && steps[j] > max)
                    max = steps[j];
            }
            steps[i] = max + 1;
            if(MAX < steps[i]) MAX = steps[i];
        }
        return MAX;
    }
}
