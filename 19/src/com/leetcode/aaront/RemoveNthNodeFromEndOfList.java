package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/3/12
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode point = head;
        for (int i = 2; i <= 2; i++) {
            ListNode temp = new ListNode(i);
            point.next = temp;
            point = point.next;
        }

        point.next = null;

//        while(head!=null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        removeNthFromEnd(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode moveNode = head;

        Integer len = 1;

        // 将moveNode移动到链表的尾部

        while (moveNode.next != null) {

            moveNode = moveNode.next;

            len++;

        }

        // 链表长度为1
        if (head == moveNode) {

            return null;

        }

        // 删除链表的第一个节点
        if (len == n) {

            return head.next;

        }

        ListNode preDeletedNode = head;
        for (int i = 1; i < len - n; i++) {
            preDeletedNode = preDeletedNode.next;
        }

        preDeletedNode.next = preDeletedNode.next.next;

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
