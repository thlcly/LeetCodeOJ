package com.leetcode.aaront;

import java.util.Stack;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(52));

    }

    public static String convertToTitle(int n) {
        if(n<=26)return String.valueOf((char)(64+n));
        StringBuilder sb = new StringBuilder("");
        Stack<Integer> stack = new Stack<>();
        int rest = n;
        while(rest > 26){
            int result = rest / 26;
            stack.push(result);
            rest = n % 26;
        }

        for(int i=0,len=stack.size();i<len;i++){
            Integer ii = stack.pop();
            sb.append((char)(64+ii));
        }
        sb.append((char)(64+rest));
        return sb.toString();
    }
}
