package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/6/22
 */
public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix k = new KthSmallestElementInASortedMatrix();
        System.out.println(k.kthSmallest(new int[][]{
                {1, 2},
                {1, 3}
        }, 2));
    }

    /**
     * 该题实际上就是求解TOP K小的元素
     * 思路: 建立一个大小为K的最大堆, 那么堆顶就是第K小的元素. 然后遍历剩余的元素, 如果元素小于堆顶元素就将堆顶替换并重新构建最大堆,
     *      当元素全部都遍历完之后, 堆顶的就是第K小的元素.
     *
     */
    public int kthSmallest(int[][] matrix, int k) {

        int[] ele = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ele[index++] = matrix[i][j];
            }
        }

        int[] arr = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            arr[i] = ele[i - 1];
        }

        for (int m = arr.length / 2; m >= 1; m--) {
            shiftDown(arr, m);
        }

        for(int i = k;i<ele.length;i++) {
            if (ele[i] < arr[1]) {
                arr[1] = ele[i];
                shiftDown(arr, 1);
            }
        }
        return arr[1];
    }

    public void shiftDown(int[] arr, int i) {
        while (i * 2 < arr.length) {
            int max = i;
            if (arr[i * 2] > arr[max]) max = i * 2;
            if (i * 2 + 1 < arr.length && arr[i * 2 + 1] > arr[max]) max = i * 2 + 1;
            if (max != i) {
                swap(arr, max, i);
                i = max;
                continue;
            }
            break;
        }
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
