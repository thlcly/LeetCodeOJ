package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/9
 */
public class BullsAndCows {
    public static void main(String[] args) {
        System.out.println(getHint("011", "110"));
    }

    public static String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        String[] s1 = secret.split("");
        String[] s2 = guess.split("");
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals(s2[i])) {
                bull++;
                s1[i] = "";
                s2[i] = "";
            }
        }
        for(int i=0;i<s1.length;i++) {
            for (int j = 0; j < s1.length; j++) {
                if (s2[i].equals(s1[j]) && !"".equals(s2[i]) && !"".equals(s1[j])) {
                    cow++;
                    s1[j] = "";
                    break;
                }
            }
        }
        return String.format("%sA%sB", bull, cow);
    }
}
