package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/2/28
 */
public class Base7 {
    public static void main(String[] args) {
        Base7 base7 = new Base7();
        System.out.println(base7.convertToBase7(100));
        System.out.println(base7.convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if (num == 0) return "";
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int remainder = num % 7;
            sb.append(remainder);
            num = num / 7;
        }
        if (!isNegative) return sb.reverse().toString();
        return sb.reverse().insert(0, "-").toString();
    }
}
