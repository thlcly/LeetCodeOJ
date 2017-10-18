package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 2017/10/18
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {

    }

    /**
     * 思路都类似, 可以看看discuss, 可以只使用一个stack(计算好a+b的值放入) , 可以不定义一个carry变量等一些有新意的思路
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer[] array1 = traverseList(l1);
        Integer[] array2 = traverseList(l2);
        int carry = 0;
        ListNode head = null;
        int i = array1.length - 1;
        int j = array2.length - 1;
        for(;i >= 0 || j >=0 ;i--,j--) {
            int sum = carry;
            if(i>=0) sum += array1[i];
            if(j>=0) sum += array2[j];
            head = addNode(sum, head);
            carry = sum / 10;
        }

        if (carry > 0) {
            ListNode ln = new ListNode(carry);
            ln.next = head;
            head = ln;
        }

        return head;
    }

    public ListNode addNode(int sum, ListNode head) {
        int carry = sum / 10;
        sum = sum % 10;
        ListNode ln = new ListNode(sum);
        ln.next = head;
        head = ln;
        return head;
    }

    public Integer[] traverseList(ListNode l) {
        List<Integer> list = new ArrayList<>();
        while (l != null) {
            list.add(l.val);
            l = l.next;
        }
        return list.toArray(new Integer[0]);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}