package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/2/24
 */
public class DetectCapital {
    public static void main(String[] args){
        DetectCapital detectCapital = new DetectCapital();
        System.out.println(detectCapital.detectCapitalUse("google"));
    }

    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|[a-z]*|[A-Z][a-z]*");
    }
}
