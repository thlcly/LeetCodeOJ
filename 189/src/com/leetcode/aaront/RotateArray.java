package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class RotateArray {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * 效率较低,不能ac
     * @param nums
     * @param k
     */

    public static void rotate(int[] nums, int k) {
        int step=k%nums.length;
        for (int i = 0; i <= step; i++) {
            int temp = nums[0];
            move(nums);
            nums[nums.length-1] = temp;
        }
    }

    public static void move(int[] nums) {
        for (int i = 0, len = nums.length; i < len - 1; i++) {
            nums[i]=nums[i+1];
        }
    }
}
