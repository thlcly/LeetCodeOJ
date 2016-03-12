package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/13
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,0};
        int[] nums2 = {2};

        merge(nums1, 1, nums2, 1);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

    }

    /**
     *
     * 注意点:要注意nums1有效元素为0(m=0)的情况, num2的所有元素都比nums1的大(nums[0] >= nums[length-1])的情况
     *
     * 思路: 找到nums2的元素在nums1中应该插入的位置(nums2元素<nums1元素的第一个位置, index),然后将nums1的index元素后的元素向后以后
     *      将nums2的元素插入
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if(nums2[i] >= nums1[m-1]){
                nums1[m] = nums2[i];
                m++;
            }
            for (int j = 0; j < m; j++) {
                if (nums2[i] < nums1[j]) {
                    moveElement(nums1, m, j, nums2[i]);
                    m++;
                    break;
                }
            }
        }
    }

    public static void moveElement(int[] nums, int len, int index, int value) {
        for (int i = len; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = value;
    }

}
