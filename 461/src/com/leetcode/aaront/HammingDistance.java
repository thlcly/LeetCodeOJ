package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/2/11
 */
public class HammingDistance {
    public static void main(String[] args){
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1,3));
    }

    /**
     * 思路: 将整数的每一位和1<<i(0<=i<=31)进行&运算, 将结果放到int[32]的数组中, 就相当于是将
     * 整数转成bit, 然后将两个数组进行比较找出不相同的
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        int[] xBit = convertToBit(x);
        int[] yBit = convertToBit(y);
        for(int i = 0;i<32;i++) {
            if(xBit[i] != yBit[i]) count++;
        }
        return count;
    }

    public int[] convertToBit(int number) {
        int[] arr = new int[32];
        for (int i = 0;i<32;i++) {
            if((number & (1 << i)) != 0) arr[i] = 1;
        }
        return arr;
    }

    /**
     * 思路: x ^ y => 相同位置不同的值返回结果才是1, 所以将两个数进行异或运算, 然后统计结果值中的1的
     * 个数就行了
     *
     */
    public int betterMethod(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
