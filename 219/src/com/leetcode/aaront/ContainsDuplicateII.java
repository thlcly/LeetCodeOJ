package com.leetcode.aaront;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tonyhui
 * @since 16/4/9
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(containsNearbyDuplicate(nums, 0));
    }

    /**
     * 注意: 这里使用数组遍历和Arraylist效率都不高(都超时),使用hashmap效率更高
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i = 0; i < length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && i - index <= k) return true;
            map.put(nums[i], i); // 如果不存在则添加,如果已经存在则用新的元素替代旧的,因为新的元素index > 旧的元素index
        }
        return false;
        /* 使用arraylist效率低
        List<Integer> list = new ArrayList<>(length-k);
        for(int i = length-k;i<length;i++){
            list.add(nums[i]);
        }
        */
        /* 使用数组遍历效率低
        for(int i = 0,len=length-k;i<len;i++){
            int value1= nums[i];
            for(int j = i+k;j<length;j++){
                if(value1 == nums[j]) return true;
            }
            // if(list.contains(value1)) return true;
            if(map.get(value1)!=null) return true;
        }
        */
    }
}
