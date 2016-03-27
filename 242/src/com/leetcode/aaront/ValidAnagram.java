package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/27
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    /**
     * 思路: 将各个字母出现的次数依次存放在数组中,然后比较数组中每个元素是否相等
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ss = new int[26];
        int[] tt = new int[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            ss[s.charAt(i)-97]++;
            tt[t.charAt(i)-97]++;
        }
        for(int i = 0,len=ss.length;i<len;i++){
            if(ss[i]!=tt[i])return false;
        }
        return true;
    }
}
