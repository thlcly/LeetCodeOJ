package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/30
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args){


    }
}

class NumArray {
    int[] table;

    /**
     * 思路: 在table里面存放累计和:
     *
     *  table[1] = nums[0];
     *  table[2] = nums[0] + nums[1];
     *  table[3] = nums[0] + nums[1] + nums[2];
     *  table[i] = nums[0] + nums[1] + ... + table[i-1];
     *  table[i + 1] = nums[0] + nums[1] + ... + table[i - 1] + table[i];
     *  table[j] = nums[0] + nums[1] + ... + table[i-1] + table[i] + table[j-1] ;
     *  table[j + 1] = nums[0] + nums[1] + ... + table[i-1] + table[i] + table[j-1] + table[j] ;
     *
     * 所以: 要计算[i, j]的值:
     * table[j + 1] - table[i];
     *
     * @param nums
     */
    public NumArray(int[] nums) {
        int sum = 0;
        table = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
        {
            sum = sum + nums[i];
            table[i + 1] = sum;
        }
    }
    public int sumRange(int i, int j) {
        return table[j+1] - table[i];
    }
}

