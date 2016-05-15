package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/13
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        int len = removeDuplicates(arr);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * 移除数组中的重复的元素(不创建新的空间,在原有的数组上进行操作)
     * 思路:
     * 1. 数组的长度是动态改变的
     * 2. 外循环: 遍历数组的每一个元素(i), 内循环: 遍历数组开头(0)到i的所有的元素
     * 查找(0~i)中是否存在元素arr[index] == arr[i]
     * 如果存在: 将后面的元素全部往前移动一位覆盖arr[i]的值 && len-- && i--(因为当前arr[i]的数据已经改变,所以要保持i不变,判断新的arr[i]是否也存在重复的元素)
     * 如果不存在: 遍历下一个元素
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    movePosition(nums, i, len);
                    i--;
                    len--;
                    break;
                }
            }
        }
        return len;
    }

    /**
     * 移动元素, 覆盖nums[startIndex]的值
     *
     * @param nums
     * @param startIndex 待覆盖的值
     * @param endIndex   从哪个下标开始进行覆盖
     */
    public static void movePosition(int[] nums, int startIndex, int endIndex) {
        for (int i = startIndex + 1; i < endIndex; i++) {
            nums[i - 1] = nums[i];
        }
    }
}
