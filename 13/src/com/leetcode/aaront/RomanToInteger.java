package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/2/7
 */
public class RomanToInteger {

    public static void main(String[]args){

    }

    public static int romanToInt(String s) {
        try {
            return Integer.valueOf(s);
        }catch(NumberFormatException e){
            return 0;
        }
    }
}
