package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/20
 */
public class ReverseLinkedList {
    public static void main(String[] args) {


    }

    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = new ListNode(-1);
        ListNode tmp = null;
        while(head!=null){
            tmp = head.next;
            head.next = reverseHead.next;
            reverseHead.next = head;
            head = tmp;
        }
        return reverseHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
