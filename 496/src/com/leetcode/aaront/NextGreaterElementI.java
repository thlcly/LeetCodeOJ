package com.leetcode.aaront;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author tonyhui
 * @since 17/2/23
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        int[] greaterElement = nextGreaterElementI.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        greaterElement = nextGreaterElementI.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(greaterElement));
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] greaterElements = new int[findNums.length];
        for (int i = 0, len = findNums.length; i < len; i++) {
            int pos = findPos(findNums[i], nums);
            if (pos == -1) greaterElements[i] = -1;
            int j = pos;
            for (; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    greaterElements[i] = nums[j];
                    break;
                }
            }
            if (j == nums.length) greaterElements[i] = -1;
        }
        return greaterElements;
    }

    private int findPos(int num, int[] array) {
        for (int i = 0, len = array.length; i < len; i++) {
            if (array[i] == num) return i;
        }
        return -1;
    }

    public int[] betterMethod(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
