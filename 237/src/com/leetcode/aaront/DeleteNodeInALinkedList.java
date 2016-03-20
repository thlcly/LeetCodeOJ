package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class DeleteNodeInALinkedList {

    public static void main(String[] args){

        deleteNode(null);

    }

    public static void deleteNode(ListNode node) {
        if (node==null || node.next==null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}