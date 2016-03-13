package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/13
 */
public class NimGame {
    public static void main(String[] args) {

        System.out.println(canWinNim(4));

    }

    /**
     * 思路: 轮到谁拿时如果只剩下4颗就一定是输,所以只要是4的倍数就一定是输(我先拿),
     *      因为可以把4的倍数分成n/4份看,只要对手每一次拿都凑足4即拿完一份最后剩下的就一定是4,我就一定会输
     *
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {

        if (n % 4 == 0) return false;
        return true;

    }
}
