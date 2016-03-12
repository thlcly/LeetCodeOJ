package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/12
 */
public class AddBinary {

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));

    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<Math.abs(a.length() - b.length());i++){
            sb = sb.append(0);
        }
        if(a.length() > b.length()){
            sb = sb.append(b);
            b = sb.toString();
        }else{
            sb = sb.append(a);
            a=sb.toString();
        }

        String[] aStr = a.split("");
        String[] bStr = b.split("");
        int jinwei = 0;
        for (int len = aStr.length,i = len - 1; i >= 0; i--) {
            int sum = Integer.valueOf(aStr[i]) + Integer.valueOf(bStr[i]) + jinwei;
            if (sum > 1) {
                sum = sum - 2;
                jinwei = 1;
            }else {
                jinwei = 0;
            }
            aStr[i] = sum + "";
        }


        StringBuilder builder = new StringBuilder();
        for(String s : aStr) {
            builder.append(s);
        }

        if(jinwei > 0){
            builder = builder.insert(0,1);
        }

        return builder.toString();
    }

}
