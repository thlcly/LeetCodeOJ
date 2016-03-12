package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 16/2/9
 */
public class PlusOne {

    public static void main(String[]args){

    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int res = digits[digits.length - 1] + 1;
        if(res >= 10){
            res = carry % 10;
            carry = 1;
        }
        digits[digits.length - 1] = res;
        for(int i = digits.length - 2; i>=0; i--){
            res = digits[i] + carry;
            carry = 0;
            if(res >= 10){
                res = carry % 10;
                carry = 1;
            }
            digits[i] = res;
        }
        if(carry == 1){
            int[] d = new int[digits.length + 1];
            d[0] = 1;
            for(int i=1;i<digits.length;i++){
                d[i] = digits[i];
            }
            return d;
        }
        return digits;
    }
}
