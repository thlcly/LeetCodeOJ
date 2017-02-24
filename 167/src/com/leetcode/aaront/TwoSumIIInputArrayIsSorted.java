package com.leetcode.aaront;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tonyhui
 * @since 17/2/24
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 3, 4}, 6)));
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        int[] array = new int[2];
        for (int i = 0, len = numbers.length; i < len; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0, len = numbers.length; i < len; i++) {
            int factor = target - numbers[i];
            Integer index = map.get(factor);
            if (index != null && index != i) {
                array[0] = i + 1;
                array[1] = index + 1;
                return array;
            }
        }
        return array;
    }

    /**
     * 思路: 从头部和尾部向中间逼近, 因为数组是递增的且一定有解, 所以当v>target时, 尾部指针向前移动(如果是头部指针移动则v变得更大), 反之, 头部指针
     * 向后移动
     */
    public int[] betterMethod(int[] num, int target) {
        int[] indice = new int[2];
        if (num == null || num.length < 2) return indice;
        int left = 0, right = num.length - 1;
        while (left < right) {
            int v = num[left] + num[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }
}
