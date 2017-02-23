package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 17/2/23
 */
public class FizzBuzz {
    public static void main(String[] args) {

    }

    public List<String> fizzBuzz(int n) {
        List<String> strs = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                strs.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strs.add("Fizz");
            } else if (i % 5 == 0) {
                strs.add("Buzz");
            } else {
                strs.add(i + "");
            }
        }
        return strs;
    }
}
