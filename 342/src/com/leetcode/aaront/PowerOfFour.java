package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/30
 */
public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(10));
        System.out.println(isPowerOfFour(16));
    }

    public static boolean isPowerOfFour(int num) {
        if(num < 1) return false;
        double d = Math.floor(Math.log10(num) / (Math.log10(4)));
        return Math.pow(4, d) == num;
    }
}
