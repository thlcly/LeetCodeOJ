package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/27
 */
public class LinkedListCycleII {
    /**
     * 思路: 使用两个指针, 一个走两步(i), 一个走一步(j). 具体的思路看@see <a href="https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything/2?page=1">https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything/2?page=1</a>,
     * 至于i一定会在j走完一次循环之前赶上j还要再想想
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode i = head;
        ListNode j = head;
        boolean isCycle = false;
        while(i != null && i.next != null) {
            i = i.next.next;
            j = j.next;
            if(j == i) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle) return null;
        j = head;
        while(i != j) {
            i = i.next;
            j = j.next;
        }
        return i;
    }
}
