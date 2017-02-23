package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/2/23
 */
public class NumberComplement {
    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(Integer.highestOneBit(5));
        System.out.println(numberComplement.findComplement(5));
    }

    public int findComplement(int num) {
        int pos = 1;
        byte[] bytes = new byte[32];
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & num) != 0) {
                bytes[31 - i] = 1;
            } else {
                bytes[31 - i] = 0;
            }
        }

        int i = 0;
        for (; i < 32; i++) {
            if (bytes[i] == 1) break;
        }

        int sum = 0;
        for (int j = 31; j >= i; j--) {
            if (bytes[j] == 0) sum += Math.pow(2, 31 - j);
        }

        return sum;
    }

    /**
     * 思路: 找到num的最高位的1的位置(POS)代表的值, 然后-1, 就是num的mask(POS后的位置都为1), 就达到了去除前置0带来的问题了
     */
    public int betterMethod(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }
}
