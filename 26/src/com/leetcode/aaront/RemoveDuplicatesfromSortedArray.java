package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/13
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));

    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 1) return 1;
        if(len == 2) {
            if(nums[0] == nums[1]) return 1;
            return 2;
        }
        int j;
        for (int i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) continue;
                int temp = i;
                movePosition(nums, temp + 1, j, len);
                //i++;
                len = len - (j - temp - 1);
                break;
            }
            if(nums[i] == nums[j-1]){
                len = len-1-i;
            }
        }
        return len;
    }

    public static void movePosition(int[] nums, int startIndex, int endIndex, int len) {
        for (int i = endIndex; i < len; i++, startIndex++) {
            nums[startIndex] = nums[i];
        }
    }
}
