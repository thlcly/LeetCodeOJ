package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/21
 */
public class OddEvenLinkedList {
    public static void main(String[] args){

    }

    /**
     * 思路: 链表从1开始, 即第一个node是odd node
     * 1. 将链表中的奇数node串成一串, 记为oddHead, 尾记为oddTail
     * 2. 将链表中的偶数node串成一串, 记为evenHead
     * 3. oddTail.next = evenHead
     */
    public ListNode oddEvenList(ListNode head) {
        // 这里的head即为oddHead
        if(head != null) {
            // 定义evenHead, 即为oddHead的下一个node
            ListNode evenHead = head.next;
            // 第一个奇数节点即为oddHead
            ListNode oddNode = head;
            // 第一个偶数节点即为evenHead
            ListNode evenNode = evenHead;
            while(oddNode.next != null && evenNode.next != null) {
                // 查找下一个奇数节点
                oddNode.next = oddNode.next.next;
                // oddNode.next = evenNode.next; 因为下一个奇数节点和偶数节点是相邻的, 所以下一个奇数节点就是和偶数节点相邻的下一个节点

                // 查找下一个偶数节点
                evenNode.next = evenNode.next.next;
                // 将当前奇数节点移动到下一个奇数节点
                oddNode = oddNode.next;
                // 将当前偶数节点移动到一个偶数节点
                evenNode = evenNode.next;
            }
            // 将偶数串加到最后一个奇数节点后面
            oddNode.next = evenHead;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
