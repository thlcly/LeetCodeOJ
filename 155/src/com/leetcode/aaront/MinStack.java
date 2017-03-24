package com.leetcode.aaront;

import java.util.Arrays;

/**
 * 思路: 因为获取最小值也需要在常量时间内完成, 所以在push每一个元素的时候都记录在这个元素是top的状态下的最小值并和min比较更新min, 同时在pop的时候更新min
 *
 * @author tonyhui
 * @since 17/3/24
 */
public class MinStack {
    private int[] data;
    private int[] mins;
    private int top;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new int[100];
        mins = new int[100];
        top = 0;
        min = 0;
    }

    public void push(int x) {
        if (top >= data.length) {
            grow();
        }
        data[top++] = x;
        if (top == 1) {
            min = data[0];
        }
        if (x < min) {
            mins[top - 1] = x;
            min = x;
        } else {
            mins[top - 1] = min;
        }
    }

    public void pop() {
        if (top <= 0) return;
        int ele = top();
        this.top--;
        if(top > 0) {
            min = mins[top - 1];
        }
    }

    public int top() {
        if (top <= 0) return 0;
        return data[top - 1];
    }

    public int getMin() {
        return min;
    }

    private void grow() {
        data = Arrays.copyOf(data, data.length * 2);
        mins = Arrays.copyOf(mins, data.length * 2);
    }
}
