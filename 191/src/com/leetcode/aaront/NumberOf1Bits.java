package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class NumberOf1Bits {
    public static void main(String[] args){

    }

    /**
     * 注意:这里split的时候不能使用0进行split,因为如果n=1111111111..(LEN=32),split就失败了
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        String binaryString = Integer.toBinaryString(n);
        String[] str = binaryString.split("");
        for(int i = 0;i<str.length;i++){
            if("1".equals(str[i]))count++;
        }
        return count;
    }

}
