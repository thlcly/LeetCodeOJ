package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/5/15
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    /**
     * 思路: 判断一个链表是否存在回路
     * 1. 设置两个指针,一个指针每次走一步,一个指针每次走两步
     * 2. 如果两个指针都没有走完链表且相遇了(oneStep==twoStep)说明存在回路
     * 3. 如果任何一个指针走完了还没有相遇,说明不存在回路
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        while (oneStep != null && twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
