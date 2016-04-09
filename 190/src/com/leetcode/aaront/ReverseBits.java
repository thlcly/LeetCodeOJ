package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/27
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        if(n==1) return n;
        if(n == Integer.MAX_VALUE) return  n;
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        if (sb.length() < 32) {
            for (int i = 0, len = sb.length(); i < 32 - len; i++) {
                sb.insert(0, '0');
            }
        }
        sb.reverse();
        return Integer.valueOf(sb.toString(), 2);
    }
}
