package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/23
 */
public class ReverseNodesInKGroup {
    /**
     * 思路: 使用递归来实现, 先对链表以k为长度分解, 然后从最后开始合并, 分割链表变成一个个长度<=k的分组, 分割使用递归来实现, 将cur作为下一次递归的head
     * 1. 如果链表的长度不为k(只会在最后的一个组出现)则直接返回head
     * 2. 如果分组长度 == k, 则进行分割, 将cur作为head传入. 直到cur遍历到链表结尾, 或者链表长度不为k, 则将head返回到上一层
     * 3. 进行归并, 此时的head是上一层传来的cur, 此时的cur是下一层返回的head, 所以只要反转cur到head之间的节点即可
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        // 对链表进行分割
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if(count == k) {
            // 如果链表长度 == k, 则再进行分割.
            // 递归返回, cur是下一层的head
            cur = reverseKGroup(cur, k);

            // 对head和cur之间的节点进行反转处理
            while(count-- > 0) {
                ListNode node = head.next;
                head.next = cur;
                cur = head;
                head = node;
            }
            // 返回当前组的head, 作为上一层的cur
            return cur;
        }
        // 如果count != k, 则直接返回, 这里的head将作为上一层的cur
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
