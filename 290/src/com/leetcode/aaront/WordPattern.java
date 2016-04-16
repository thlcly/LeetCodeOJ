package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/16
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("jquery", "jquery"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] array = new String[26];
        String[] strs = str.split(" ");
        int len = pattern.length();
        if (strs.length != len) return false;
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            String ss = array[c - 97];
            if (containValue(array, s, c - 97))return false;
            if(ss == null){
                array[c-97] = s;
                continue;
            }
            if(!ss.equals(s))return false;
        }
        return true;
    }

    public static boolean containValue(String[] array, String str, int c) {
        for (int i = 0; i < array.length; i++) {
            if(i == c) continue;
            if(str.equals(array[i])) return true;
        }
        return false;
    }
}
