package com.leetcode.aaront;

import java.util.*;

/**
 * @author tonyhui
 * @since 17/6/21
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        System.out.println(t.topKFrequent(new int[]{-1, 1, 4, -4, 3, 5, 4, -2, 3, -1}, 3));
    }

    /**
     * 该题的本质是求解TOP K 问题.
     * 思路: 这里以求解最大的TOP K为例(求解最小的类似).
     * 首先建立所有数据的最大堆, 然后开始遍历(遍历的次数是K的数量), 每次遍历都取堆顶元素(由最大堆的性质可知, 堆顶的数是最大的), 然后将最后一个元素
     * 替换堆顶重新建堆, 以此循环.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                Point p = new Point(nums[i], 0);
                map.put(nums[i], p);
            }
            map.get(nums[i]).c++;

        }
        List<Point> points = new ArrayList<>(map.values().size());
        points.add(new Point(0, 0));
        points.addAll(map.values());
        Point[] topK = points.toArray(new Point[0]);
        // 建立最大堆
        for (int i = points.size() / 2; i >= 1; i--) {
            shiftDown(topK, i, topK.length);
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = 1; i <= k; i++) {
            result.add(topK[1].n);
            topK[1] = topK[topK.length - i];
            shiftDown(topK, 1, topK.length - i);
        }
        return result;
    }

    private void shiftDown(Point[] p, int i, int length) {
        while (i * 2 < length) {
            int max = i;
            if (p[max].c < p[i * 2].c) max = i * 2;
            if (i * 2 + 1 < length && p[max].c < p[i * 2 + 1].c) {
                max = i * 2 + 1;
            }
            if (max != i) {
                swap(p, max, i);
                i = max;
                continue;
            }
            break;
        }
    }

    private void swap(Point[] points, int i, int j) {
        Point p = points[i];
        points[i] = points[j];
        points[j] = p;
    }

}

class Point {
    int n;
    int c;

    public Point(int n, int c) {
        this.n = n;
        this.c = c;
    }
}
