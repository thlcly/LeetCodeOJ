package com.leetcode.aaront;

import java.util.*;

/**
 * @author tonyhui
 * @since 17/6/20
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        SortCharactersByFrequency scbf = new SortCharactersByFrequency();
        System.out.println(scbf.frequencySort("raaeaedere"));
    }

    /**
     * 思路: 使用最大堆的性质, 每次获取第一个节点的数据, 然后将最后一个节点放到第一个节点再次进行shiftDown(向下调整操作), 直到全部的数据都被获取
     */
    public String frequencySort(String s) {
        Map<Character, Point> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            Point point = map.computeIfAbsent(key, k -> new Point(key, 0));
            point.count++;
        }
        List<Point> points = new ArrayList<>(map.values().size());
        points.add(new Point(' ', 0));
        points.addAll(map.values());
        Point[] p = points.toArray(new Point[0]);
        setup(p);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p.length - 1; i++) {
            for (int j = 0; j < p[1].count; j++) sb.append(p[1].c);
            p[1] = p[p.length - i];
            shiftDown(1, p, p.length - i);
        }
        return sb.toString();
    }

    public void setup(Point[] arr) {
        for (int i = arr.length / 2; i >= 1; i--) {
            shiftDown(i, arr, arr.length);
        }
    }

    public void shiftDown(int i, Point[] points, int length) {
        while (i * 2 < length) {
            int max = i;
            if (points[i].count < points[i * 2].count) max = i * 2;
            if (i * 2 + 1 < length) {
                if (points[i * 2 + 1].count > points[max].count) max = i * 2 + 1;
            }
            if (max != i) {
                swap(max, i, points);
                i = max;
                continue;
            }
            break;
        }
    }

    public void swap(int i, int j, Point[] points) {
        Point point = points[i];
        points[i] = points[j];
        points[j] = point;
    }

}

class Point {
    char c;
    int count;

    public Point(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
