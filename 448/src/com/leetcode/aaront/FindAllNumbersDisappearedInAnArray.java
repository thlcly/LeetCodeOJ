package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 17/2/24
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray f = new FindAllNumbersDisappearedInAnArray();
        System.out.println(f.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] statistics = new int[nums.length + 1];

        for (int num : nums) {
            statistics[num] = 1;
        }
        List<Integer> disappeared = new ArrayList<>();
        for (int i = 1, len = statistics.length; i < len; i++) {
            if (statistics[i] == 1) continue;
            disappeared.add(i);
        }
        return disappeared;
    }
}

