package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/25
 */
public class SortList {
    /**
     * 使用归并排序即可解决, 但是空间复杂度不一定是O(1) ?
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode tail = head;
        while(tail != null) {
            tail = tail.next;
            count++;
        }
        ListNode cur = head;
        for(int i = 1;i<count/2;i++) {
            cur = cur.next;
        }
        ListNode node = cur.next;
        cur.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(node);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while(left != null || right != null) {
            if(left == null) {
                node.next = right;
                right = right.next;
            } else if(right == null) {
                node.next = left;
                left = left.next;
            } else {
                int v1 = left.val;
                int v2 = right.val;
                if(v1 < v2) {
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;
                }
            }
            node = node.next;
        }
        return head.next;
    }
}
