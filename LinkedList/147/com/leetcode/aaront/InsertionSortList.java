package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/26
 */
public class InsertionSortList {
    public static void main(String[] args){

    }

    /**
     * 思路: 插入排序的思想就是有一个临界位置, 这个位置之前是排序好的, 这个位置之后是未排序的
     * 1. 针对链表来说, 这个临界位置可以用head来替代, head之前是排序好的, head之后是未排序的
     * 2. 如果一个节点要进行排序, 只要遍历(root, head]之间的节点就可以了
     * 3. 如果节点的值比head还大, 直接head往后移动一位即可
     * 4. 如果节点的值处于以排序的节点中间, 则将这个节点插入, 然后head指向该节点的下一个节点即可
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode tail = head.next;
        while(tail != null) {
            ListNode next = tail.next;
            ListNode pre = root;
            ListNode cur = root.next;
            while(cur != head.next && cur.val < tail.val) {
                pre = cur;
                cur = cur.next;
            }
            if(cur == head.next) {
                head = tail;
            } else {
                pre.next = tail;
                tail.next = cur;
                head.next = next;
            }
            tail = head.next;
        }
        return root.next;
    }
}
