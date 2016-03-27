package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/27
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args){

        System.out.println(titleToNumber("AA"));

    }

    /**
     * 思路: 可以看成是一个26进制(A-Z)的操作
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        StringBuilder sb = new StringBuilder(s);
        String strs = sb.reverse().toString();
        int sum = 0;
        for(int i = 0,len=strs.length();i<len;i++){
            sum += (strs.charAt(i) - 64) * Math.pow(26,i);
        }
        return sum;
    }
}
