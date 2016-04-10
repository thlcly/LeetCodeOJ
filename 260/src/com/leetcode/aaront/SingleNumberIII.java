package com.leetcode.aaront;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tonyhui
 * @since 16/4/10
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 5, 2})));
    }

    public static  int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            Integer number = map.get(nums[i]);
            if (number == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], number + 1);
            }
        }
        int i=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) res[i++] = entry.getKey();
        }
        return res;
    }
}
