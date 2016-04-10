package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/10
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("helloworld", "owr"));
        "abc".indexOf("a");
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null) return -1;
        if (needle == null) return -1;
        if(needle.length() == 0) return 0;
        for (int i = 0, len1 = haystack.length(); i < len1; i++) {
            // 找到匹配第一个字母的位置
            if (needle.length() > 0 && haystack.charAt(i) == needle.charAt(0)) {
                int dis = i + needle.length();
                if (dis > len1) return -1;
                String str = haystack.substring(i, dis);
                if (str.equals(needle)) return i;
            }
        }
        return -1;
    }
}
