package com.aaront.leetcode;

/**
 * @author tonyhui
 * @since 17/1/24
 */
public class HouseRobber {

    /**
     * 思路: 这个是一个典型的DP问题, DP问题的解决关键就是找到状态转移方程
     *
     * 状态转移方程: A(i) = max(A(i - 1), A(i - 2) + nums[i])
     *
     * i表示房子的数量, A表示偷i幢房子的最大收益, nums表示每幢房子的收益
     *
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= 1) return nums[0];
        int[] money = new int[nums.length + 1];
        money[0] = 0;
        money[1] = nums[0];

        for(int i = 2, len = money.length; i < len; i++) {
            money[i] = max(money[i-1], money[i-2] + nums[i - 1]);
        }
        return money[money.length - 1];
    }

    public int max(int money1, int money2) {
        return money1 > money2 ? money1 : money2;
    }
}
