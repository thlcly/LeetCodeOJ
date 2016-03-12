package com.leetcode.aaront;

import java.util.Stack;

/**
 * @author tonyhui
 * @since 16/3/12
 */
public class ValidParentheses {

    public static void main(String[] args){

        System.out.println(isValid("("));

    }

    public static boolean isValid(String s) {
        char [] chars = {'(','[','{'};
        Stack<Character> stack = new Stack<>();
        boolean contains = false;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j = 0;j<chars.length;j++){
                if(chars[j] == c){contains = true;break;}
            }
            if(contains){
                stack.push(c);
                contains = false;
            }else{
                if(stack.empty())return false;
                char top = stack.pop();
                switch (top){
                    case '(':
                        if(c==')')continue;
                        else return false;
                    case '[':
                        if(c==']')continue;
                        else return false;
                    case '{':
                        if(c=='}')continue;
                        else return false;
                }
            }
        }
        if (stack.empty())
            return true;
        return false;
    }

}
