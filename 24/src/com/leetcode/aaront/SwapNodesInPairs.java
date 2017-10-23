package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 2017/10/23
 */
public class SwapNodesInPairs {
    /**
     * 25题是这题的抽象形式, 所以可以用25题的解法来解决
     */
    /*
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != 2) {
            cur = cur.next;
            count++;
        }
        if(count == 2) {
            cur = swapPairs(cur);
            while(count-- > 0) {
                ListNode node = head.next;
                head.next = cur;
                cur = head;
                head = node;
            }
            return cur;
        }
        return head;
    }
    */

    /**
     * 更简单的递归方式
     */
    /*
    public ListNode swapPairs(ListNode head) {
        // 如果节点为空, 或者只有一个节点则直接返回
        if(head == null || head.next == null) return head;
        // 获取下一个节点
        ListNode next = head.next;
        // 1. 下一个节点作为下一层的第一个节点
        // 2. swapPairs返回的是当前层的首节点
        // 3. 将当前层的首节点 -> 下一层的首节点
        head.next = swapPairs(next);
        // 4. 将当前层的第二个节点 -> 当前层的首节点, 这样就完成的转换
        next.next = head;
        // 返回当前层的首节点(这个时候的首节点就变成了之前的第二个节点)
        return next;
    }
    */

    /**
     * 上面递归的方式的空间复杂度都不是常量, 所以使用迭代的方式再实现一下
     */
    public ListNode swapPairs(ListNode head) {
        // 如果节点为空, 或者只有一个节点则直接返回
        if(head == null || head.next == null) return head;
        // 增加一个root节点, 可以使所有的节点都统一处理
        ListNode root = new ListNode(-1);
        root.next = head;
        // eg: -1->1->2->nil
        // tmp, one, two为连续的三个节点
        ListNode tmp = root;
        ListNode one = tmp.next;
        ListNode two;
        // 如果one.next == null说明只剩下一个节点了, 就不用进行交换了
        while(one != null && one.next!= null) {
            // two -> 2
            two = one.next;
            // 1 -> nil
            one.next = two.next;
            // 2 -> 1
            two.next = one;
            // -1 -> 2
            tmp.next = two;
            // -1->2->1->nil
            tmp = one;
            // 这里的one有可能为null, 所以在while循环中要进行判断
            one = tmp.next;
        }
        return root.next;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
