package com.leetcode.aaront;

import java.util.Stack;

/**
 * @author tonyhui
 * @since 17/3/24
 */
public class DecodeString {

    /**
     * 思路: 利用栈的性质, 将数字和符合分开入栈, 当遍历到']'时字符栈中直到'['之间的所以字符和数字栈的第一个数字进行repeat, 当字符遍历完之后
     *      将栈中的数据进行拼接即使最后的结果
     */
    public String decodeString(String s) {
        Stack<String> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder numSb = new StringBuilder();
        StringBuilder charSb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numSb.append(chars[i]);
            }
            else if(chars[i] == '[') {
                charStack.push(String.valueOf(chars[i]));
                intStack.push(Integer.valueOf(numSb.toString()));
                numSb.delete(0, numSb.length());
            }
            else if(chars[i] >= 'a' && chars[i] <= 'z') {
                charStack.push(String.valueOf(chars[i]));
            }
            else if(chars[i] == ']') {
                String ele = charStack.pop();
                while (!ele.equals("[")) {
                    charSb.insert(0, ele);
                    ele = charStack.pop();
                }
                Integer repeatNum = intStack.pop();
                String repeat = repeat(charSb.toString(), repeatNum);
                charStack.push(repeat);
                numSb.delete(0, numSb.length());
                charSb.delete(0, charSb.length());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.insert(0, charStack.pop());
        }
        return sb.toString();
    }

    public String repeat(String s, int repeatNum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatNum; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
       // System.out.println(ds.decodeString("3[a]2[bc]"));
        System.out.println(ds.decodeString("3[a2[c]]"));
       // System.out.println(ds.decodeString("2[abc]3[cd]ef"));
    }
}
