package com.leetcode;

/**
 * @author tonyhui
 * @since 16/2/5
 */
public class ReverseInteger {

    public static void main(String[]args){
        System.out.print(reverse(1534236469));
    }

    public static int reverse(int x) {
        StringBuilder sb = null;
        if(x>=0) sb = new StringBuilder(String.valueOf(x)).reverse();
        else sb = new StringBuilder(String.valueOf(x).substring(1)).reverse().insert(0, "-");
        try {
            return Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
