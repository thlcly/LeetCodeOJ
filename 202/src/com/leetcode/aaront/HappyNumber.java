package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 16/3/27
 */
public class HappyNumber {
    public static void main(String[] args){
        System.out.println(isHappy(9));
    }

    /**
     * 思路: 将每次的结果都存放在list中,如果某次的结果在list中存在说明已经发生了循环,不能变为1了,直接返回false
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        while(true) {
            while (n != 0) {
                int i = n % 10;
                result += i * i;
                n = n / 10;
            }
            if (result == 1) return true;
            if (list.contains(result)) return false;
            list.add(result);
            n = result;
            result=0;
        }
    }
}
