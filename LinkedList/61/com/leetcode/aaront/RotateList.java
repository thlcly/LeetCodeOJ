package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/24
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode tail = null;
        ListNode node = head;
        int count = 0;
        while (node != null) {
            tail = node;
            node = node.next;
            count++;
        }
        node = head;
        int rotate = k % count;
        for (int i = 1; i < rotate; i++) {
            head = head.next;
        }
        tail.next = node;
        ListNode root = head.next;
        head.next = null;
        return root;
    }

    public static void main(String[] args){
        //System.out.println(2000000000%3);
        RotateList r = new RotateList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        r.rotateRight(node1, 2000000000);
    }
}
