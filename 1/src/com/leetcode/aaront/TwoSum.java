package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/2/4
 */
public class TwoSum {
    public static void main(String[]args){

    }

    public int[] twoSum(int[] nums, int target) {
        int index1 = 0;
        int index2 = 0;
        label: for(int i = 0; i < nums.length; i++){
           for(int j = i + 1 ;j<nums.length; j++){
               if(nums[i] + nums[j] == target){
                   index1 = i + 1;
                   index2 = j + 1;
                   break label;
               }
           }
        }
        return new int[]{index1, index2};
    }
}
