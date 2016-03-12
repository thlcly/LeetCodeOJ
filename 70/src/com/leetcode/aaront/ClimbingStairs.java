package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/12
 */
public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(3));

    }

    /**
     *
     * 思路: 登上第n个台阶的方法=登上第n-1个台阶的方法+登上第n-2个台阶的方法  =>
     *      f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n - 1];
    }

}
