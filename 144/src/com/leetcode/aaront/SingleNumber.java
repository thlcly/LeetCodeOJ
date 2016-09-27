package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/9/27
 */
public class SingleNumber {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,6,6,1,3,5,8,9,9};
        System.out.println(singleNumber(nums));
    }

    /**
     * 思路:
     * 1. 异或(XOR)的特点:
     *  - 符合交换律 => a ^ b = b ^ a
     *  - 符合结合律 => a ^ b ^ c = a ^ (b ^ c)
     *  - 自身异或恒等于0 => a ^ a = 0
     *  - 所有的数和0异或都等于本身 => X ^ 0 => X
     *
     * 2. 因为数组中所有的数据都是成双出现的有且只有一个是单个出现的, 所以可以将数组中的所有的
     *    数据进行异或操作, 最后的值就是要寻找的单个的数据
     *
     * 3. 利用异或的特性还可以实现两个数的交换
     * eg:
     *
     * ```
     *  int a = 1, b = 2;
     *  a = a ^ b;
     *  b = a ^ b;
     *  a = a ^ b;
     * ```
     *
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
