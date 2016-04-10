package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/10
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(16));
    }

    /**
     * 思路: 阶乘以5的倍数为界限,即n/5的值就是n!末尾的0的个数,因为5的阶乘是出现第一个0的最小的n
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n/=5;
            count+=n;
        }
        return count;
    }
}
