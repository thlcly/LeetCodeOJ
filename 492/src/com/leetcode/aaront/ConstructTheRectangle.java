package com.leetcode.aaront;

import java.util.Arrays;

/**
 * @author tonyhui
 * @since 17/2/24
 */
public class ConstructTheRectangle {
    public static void main(String[] args) {
        ConstructTheRectangle ctr = new ConstructTheRectangle();
        System.out.println(Arrays.toString(ctr.constructRectangle(4)));
    }

    public int[] constructRectangle(int area) {
        int range = (int) Math.sqrt(area);
        int[] lengthWidth = new int[2];
        for (int i = range; i >= 1; i--) {
            if (area % i == 0) {
                lengthWidth[0] = area / i;
                lengthWidth[1] = i;
                break;
            }
        }
        return lengthWidth;
    }
}
