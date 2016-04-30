package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/30
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }

    /**
     * 思路: 创建一个链表的头节点(指向链表的首节点),使链表中所有节点的操作都一致
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        ListNode p = head;
        ListNode q = node;
        node.next = head;
        while (p != null) {
            if (p.val == val) {
                q.next = p.next;
            } else {
                q = q.next;
            }
            p = p.next;
        }
        return node.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}