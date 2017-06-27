package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/10
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args){

    }

    /**
     * 这道题目其实就是一道动态规划的题目
     * 思路: 动态规划的解法其实是固定的, 1. 找到状态, 2. 找到状态转移方程
     * 这道题目的状态其实分成两个, 1. 前i个月的最低值(F(i)), 2. 前i个月的最大利润(P(i))
     * F(i) = min{F(i - 1), i} // 前i个月的最低值 = min{前i-1个月的最低值, 当前月的价格}
     * P(i) = max{P(i - 1), i - F(i)} // 前i个月的利润最大值 = max{前i-1个月的利润最大值, 当前月买出时的利润}
     *
     * 找到状态转移方程可以考虑从具体到一般的过程(即先找几个具体的数据进行推算找到规律)
     *
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 0) return 0;
        int lowest = prices[0];
        int highest = 0;
        for(int i = 1;i<prices.length;i++) {
            lowest = lowest < prices[i] ? lowest : prices[i];
            highest = highest > (prices[i] - lowest) ? highest:(prices[i] - lowest);
        }
        return highest;
    }
}
