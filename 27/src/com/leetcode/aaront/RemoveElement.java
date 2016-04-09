package com.leetcode.aaront;

import java.util.Arrays;

/**
 * @author tonyhui
 * @since 16/4/9
 */
public class RemoveElement {
    public static void main(String[] args) {

        int[] nums = {3, 3};
        int len = removeElement(nums, 3);
        System.out.println(Arrays.toString(nums));
        System.out.println(len);

    }

    public static int removeElement(int[] nums, int val) {
        int arrLen = nums.length;
        for (int i = 0; i < arrLen; i++) {
            if (nums[i] == val) { // 如果匹配,则数组向前移动一位将匹配到的值覆盖, 此时i不应该++ ,因为数组在i的位置是一个新的值
                move(nums, i);
                arrLen--; // 移动一位,长度跟着-1
                i--;
            }
        }
        return arrLen;
    }

    public static void move(int[] nums, int pos) {
        for (int i = pos, len = nums.length; i < len - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
