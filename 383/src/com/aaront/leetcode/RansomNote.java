package com.aaront.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tonyhui
 * @since 16/10/1
 */
public class RansomNote {
    public static void main(String[] args) {

        System.out.println(classify("dksahccssegs"));

    }

    /**
     * 思路: 对ransomNote, magazine进行分类, 统计字符出现的次数, 然后遍历比较字符出现的数量
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteMap = classify(ransomNote);
        Map<Character, Integer> magazineMap = classify(magazine);
        for (Map.Entry<Character, Integer> entry : ransomNoteMap.entrySet()) {
            char c = entry.getKey();
            int num = entry.getValue();
            if (magazineMap.get(c) == null || magazineMap.get(c) < num) return false;
        }
        return true;
    }

    public static Map<Character, Integer> classify(String ransomNote) {
        Map<Character, Integer> map = new HashMap<>();
        if (ransomNote == null || ransomNote.isEmpty()) return map;
        int length = ransomNote.length();
        for (int i = 0; i < length; i++) {
            char temp = ransomNote.charAt(i);
            Integer num = map.get(temp);
            if (num == null) map.put(temp, 1);
            else map.put(temp, num + 1);
        }
        return map;
    }

    public static boolean betterCanConstruct(String ransomNote, String magazine) {
        // 声明长度=26的数组用于保存magazine每个字符出现的次数, 数组中每个元素的默认值是0
        int[] arr = new int[26];
        // 遍历magazine的长度, 统计每个字符出现的次数
        // 例如: 'a' 出现的次数记录在arr[0], 'b' 出现的次数记录在arr[1]
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        // 遍历ransomNote, 每遍历一个字符就把arr中相应的元素的数量-1, 如果<0则说明magazine中这个
        // 字符出现的次数 < ransoNote出现的次数, 返回false, 否则继续遍历ransomNote, 如果全都
        // 遍历完成了则返回true
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
