package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/29
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        System.out.println(reverse("hello"));
        System.out.println(reverse(""));
    }

    public static String reverseString(String s) {
        if(s == null) return null;
        StringBuilder sb = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // StringBuilder.reverse的实现(仅包含ascii部分)

    /**
     * 思路: 取中间索引, 将索引两边的字符进行对换, 只需要遍历(s.length() - 1) / 2 次
     *
     * 字符串长度为 奇数 的情况: 0  1  2  3  4
     *                对换: 2 <-> 2
     *                对换: 1 <-> 3
     *                对换: 0 <-> 4
     *
     * 字符串长度为 偶数 的情况: 0  1  2  3  4  5
     *                对换: 2 <-> 3
     *                对换: 1 <-> 4
     *                对换: 0 <-> 5
     *
     *
     *
     * @param ss
     * @return
     */
    public static String reverse(String ss) {
        if(ss == null) return null;
        StringBuilder s = new StringBuilder(ss);
        int n = s.length() - 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = s.charAt(j);
            char ck = s.charAt(k);
            s.setCharAt(j, ck);
            s.setCharAt(k, cj);
        }
        return s.toString();
    }
}
