package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/9
 */
public class CountAndSay {
    public static void main(String[] args) {

        System.out.println(countAndSay(2));
    }

    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = operator(res);
        }
        return res;
    }

    public static String operator(String str) {
        StringBuilder sb = new StringBuilder("");
        String[] arr = str.split("");
        int len = arr.length;
        for (int i = 0; i < len; ) {
            int count = 0;
            String value = arr[i];
            int j = i;
            for (; j < len; j++) {
                if (!arr[j].equals(value)) break;
                count++;
            }
            sb.append(count + value);
            i = j;
        }
        return sb.toString();
    }

}
