package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/9
 */
public class LengthOfLastWord {
    public static void main(String[] args){
        lengthOfLastWord(" ");
    }

    public static  int lengthOfLastWord(String s) {
        String[] word = s.split(" ");
        if(word.length < 1) return 0;
        return word[word.length - 1].length();
    }
}
