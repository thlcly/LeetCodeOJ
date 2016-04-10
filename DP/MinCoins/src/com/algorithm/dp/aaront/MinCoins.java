package com.algorithm.dp.aaront;

/**
 * @author tonyhui
 * @since 16/4/10
 */
public class MinCoins {
    public static void main(String[] args) {
        System.out.println(minCoins(0, new int[]{1, 3, 5}));
        System.out.println(minCoins(1, new int[]{1, 3, 5}));
        System.out.println(minCoins(2, new int[]{1, 3, 5}));
        System.out.println(minCoins(3, new int[]{1, 3, 5}));
        System.out.println(minCoins(4, new int[]{1, 3, 5}));
        System.out.println(minCoins(5, new int[]{1, 3, 5}));
        System.out.println(minCoins(6, new int[]{1, 3, 5}));
        System.out.println(minCoins(7, new int[]{1, 3, 5}));
        System.out.println(minCoins(8, new int[]{1, 3, 5}));
        System.out.println(minCoins(9, new int[]{1, 3, 5}));
        System.out.println(minCoins(10, new int[]{1, 3, 5}));
        System.out.println(minCoins(11, new int[]{1, 3, 5}));
        System.out.println(minCoins(12, new int[]{1, 3, 5}));
        System.out.println(minCoins(13, new int[]{1, 3, 5}));
        System.out.println(minCoins(14, new int[]{1, 3, 5}));
    }

    /**
     * 思路: (1) 记拿i元的最小次数: d(i) (2) d(0) = 0
     *
     *      拿n元的最少次数 = min{d(i-j) + 1} 其中j为提供的硬币的种类
     *      因为j为提供的硬币的种类,所以i-j + 1中的1实际上代表拿一次其中一种硬币的面值,
     *      而这个面值就是j的值
     *      因此一定有解
     *
     *      该dp问题 => 当前状态 = 前一种状态集合中的一个最优解 + 1(拿一次面额)
     * @param value
     * @param coins
     * @return
     */
    public static int minCoins(int value, int[] coins) {
        int[] step = new int[value + 1];
        step[0] = 0; // d(0) = 0;

        for (int i = 1; i <= value; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && step[i - coins[j]] < min)
                    min = step[i - coins[j]];
            }
            step[i] = min + 1;
        }
        return step[value];
    }
}
