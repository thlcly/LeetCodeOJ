package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {

        System.out.println(compareVersion("1", "1.0"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i ;
        for (i = 0; i < v1.length && i < v2.length; i++) {
            Integer i1 = Integer.valueOf(v1[i]);
            Integer i2 = Integer.valueOf(v2[i]);
            if (i1 > i2) return 1;
            if (i1 < i2) return -1;
        }


        if (v1.length < v2.length) {
            for(int j = i;j<v2.length;j++){
                if(Integer.valueOf(v2[j]) != 0)return -1;
            }
            return 0;
        }
        if (v1.length > v2.length) {
            for(int j = i;j<v1.length;j++){
                if(Integer.valueOf(v1[j]) != 0)return 1;
            }
            return 0;
        }
        return 0;

    }
}
