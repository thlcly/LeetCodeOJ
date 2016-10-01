package com.aaront.leetcode;

/**
 * @author tonyhui
 * @since 16/10/1
 */
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(sort("hfygtsiejfrdudd"));
    }

    public char findTheDifference(String s, String t) {
        String ss = sort(s);
        String tt = sort(t);
        for(int i = 0;i<ss.length();i++) {
            if(ss.charAt(i) != tt.charAt(i)) return tt.charAt(i);
        }
        return tt.charAt(t.length() - 1);
    }

    public static String sort(String s) {
        char[] array = s.toCharArray();
        int length = s.length();
        for(int i = 0;i<length;i++) {
            for(int j = 0;j<length-1-i;j++){
                if(array[j] > array[j+1]) {
                    char temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return new String(array);
    }
}
