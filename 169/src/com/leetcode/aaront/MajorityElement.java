package com.leetcode.aaront;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class MajorityElement {
    public static void main(String[] args){

        int[] nums = {6,5,5};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0,len = nums.length;i< len;i++){
            int value = nums[i];
            Integer count = map.get(value);
            if(count == null){
                count = new Integer(1);
                map.put(value, count);
            }else {
                count++;
                map.put(value, count);
            }
        }
        int max = 0;
        int majorityElement = 0;
        for(int i = 0,len =nums.length;i<len;i++){
            int count = map.get(nums[i]);
            if(count > max) {
                majorityElement = nums[i];
                max = count;
            }
        }
        return majorityElement;
    }


    /**
     *
     * leetcode上牛逼的解题思路
     *
     * 思路:因为majorityElement的要求是出现次数>nums[n/2],所以排序之后,在nums[n/2]的位置一定是majorityElement
     * @param nums
     * @return
     */
    public static int prefectCode(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len/2];
    }
}
