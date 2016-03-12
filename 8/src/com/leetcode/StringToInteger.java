package com.leetcode;

/**
 * @author tonyhui
 * @since 16/2/5
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.print(myAtoi("-2147483649"));
    }

    public static int myAtoi(String str) {
        if(str==null)return 0;
        if(str.equals(""))return 0;
        String s = str.trim();
        boolean flag = s.charAt(0) == '-';
        int i = flag || s.charAt(0) == '+' ? 1 : 0;
        StringBuilder sb = new StringBuilder("");
        for (int len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                sb.append(c);
            }else{
                break;
            }
        }
        if(flag){
            sb.insert(0,'-');
        }
        try {
            return Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            if(sb.toString().equals("") || sb.toString().equals("-"))return 0;
            int res1 = sb.toString().compareTo(String.valueOf(Integer.MAX_VALUE));
            boolean res2 = sb.length() > String.valueOf(Integer.MAX_VALUE).length();
            boolean res3 = sb.length() > String.valueOf(Integer.MIN_VALUE).length();
            int res4 = sb.toString().compareTo(String.valueOf(Integer.MIN_VALUE));
            if ((res1>0 || res2 ) && !flag) {
                return Integer.MAX_VALUE;
            }
            if(res4>0 || res3){
                return Integer.MIN_VALUE;
            }
            return 0;
        }

    }
}
