package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class PowerOfTwo {
    public static void main(String[] args){

        System.out.println(isPowerOfTwo(6));

    }

    public static boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1)) == 0;
    }
}
