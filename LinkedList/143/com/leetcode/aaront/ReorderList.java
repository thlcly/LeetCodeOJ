package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/26
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        // 找到链表的中间节点(second指向的节点, second指向3)eg: 1->2->3->4->5->6->nil
        ListNode temp = null;
        ListNode first = head;
        ListNode second = head;
        while(first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }

        // 反转中间节点以及之后的节点eg: 1->2->3->nil, 6->5->4->nil
        ListNode pre = null;
        ListNode cur = second.next;
        second.next = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 进行拼装
        ListNode node = head;
        while (pre != null) {
            ListNode next = node.next;
            node.next = pre;
            if(next == null) break;
            ListNode tail = pre.next;
            pre.next = next;
            node = next;
            pre = tail;
        }
    }
}
