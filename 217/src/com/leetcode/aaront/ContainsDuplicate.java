package com.leetcode.aaront;

import java.util.Arrays;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[30000];
        for(int i = 0;i<30000;i++)nums[i] = i;
        containsDuplicate2(nums);
    }

    public static boolean containsDuplicate(int[] nums) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i] && i != j) return true;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        return false;
    }

    public static boolean containsDuplicate2(int[] nums){
        long start = System.currentTimeMillis();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1])return true;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return false;
    }
}
