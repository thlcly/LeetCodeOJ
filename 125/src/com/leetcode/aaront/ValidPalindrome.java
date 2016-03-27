package com.leetcode.aaront;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tonyhui
 * @since 16/3/27
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char a = s.charAt(i);
            if (a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' || a>='0' && a<= '9') {
                stack.push(a);
                queue.add(a);
            }
        }

        for (int i = 0, len = stack.size(); i < len; i++) {
            String s1 = String.valueOf(stack.pop());
            String s2 = String.valueOf(queue.poll());
            if(!s1.equalsIgnoreCase(s2)) return false;
        }
        return true;
    }
}
