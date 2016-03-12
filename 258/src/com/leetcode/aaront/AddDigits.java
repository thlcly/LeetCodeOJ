package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/12
 */
public class AddDigits {

    public static void main(String[] args) {

        System.out.println(addDigits(38));

    }

    public static int addDigits(int num) {
        String[] str = String.valueOf(num).split("");
        int sum = 0;
        if(str.length == 1) return Integer.valueOf(str[0]);
        for (int i = 0, len = str.length; i < len; i++) {
            sum+=Integer.valueOf(str[i]);
        }
        return addDigits(sum);
    }

}
