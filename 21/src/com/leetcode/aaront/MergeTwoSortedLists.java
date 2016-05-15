package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/10
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    /**
     * 合并两个有序的链表, 思路:
     *
     * 1. 对两个链表进行遍历, 比较两个链表的每个节点的值的大小, 并将其添加到新的链表中
     * 2. 当两个链表中的任意一个遍历完了, 就把剩余的那个链表的节点加到新的列表上
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode newList = l3;
        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode(0);
            if(l1.val >= l2.val) {
                tmp.val = l2.val;
                l2 = l2.next;
            }else{
                tmp.val = l1.val;
                l1 = l1.next;
            }
            l3.next = tmp;
            l3 = tmp;
        }
        if(l1!=null) {
            l3.next = l1;
        }
        if (l2!=null) {
            l3.next = l2;
        }
        return newList.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
