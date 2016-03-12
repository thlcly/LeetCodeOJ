package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/12
 */
public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {

        //1->1->2->3->3
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        deleteDuplicates(node1);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode point1 = head;
        ListNode point2 = point1.next;
        while (point2 != null) {
            point2 = point1.next;
            //System.out.println("hello");
            int val1 = point1.val;
            if(point2 == null) break;
            while (point2 != null && point2.val == val1) {
                point2 = point2.next;
            }
            point1.next = point2;
            point1 = point2;
        }

        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
