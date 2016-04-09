package com.leetcode.aaront;

public class Main {

    public static void main(String[] args) {
        String testString1 = "   a    b   ";
        System.out.print(reverseString(testString1));
    }

    public static String reverseString(String s){


        return new StringBuilder(s).reverse().toString();
    }
}
