package com.leetcode;

/**
 * @author tonyhui
 * @since 16/2/5
 */
public class PalindromeNumber {
    public static void main(String[] args){
        System.out.println(isPalindrome(-2147447412));
    }

    public static Boolean isPalindrome(int x) {
        if(x<0)return false;
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        StringBuilder sb2 = new StringBuilder(String.valueOf(Math.abs(x)));
        sb.reverse();
        return sb.toString().equals(sb2.toString());
    }
}
