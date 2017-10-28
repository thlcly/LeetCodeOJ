package com.leetcode.aaront;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tonyhui
 * @since 2017/10/28
 */
public class CopyListWithRandomPointer {
    /**
     * 思路: 就是使用一个Map来保存旧节点和新节点之间的关系, 然后使用两次遍历来设置新节点的next和random. 这样空间复杂度是O(n), 时间复杂度是O(n), 还有另外一种做法, 很巧妙, 但是复杂度应该差不多.
     * <a href="https://discuss.leetcode.com/topic/7594/a-solution-with-constant-space-complexity-o-1-and-linear-time-complexity-o-n/6">使用链表来维护旧节点和新节点的关系</a>
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode root = new RandomListNode(-1);
        RandomListNode node = root;
        RandomListNode cur = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            node.next = tmp;
            node = tmp;
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        node = root.next;
        while(cur != null) {
            RandomListNode random = cur.random;
            if(random == null) {
                cur = cur.next;
                node = node.next;
                continue;
            }
            node.random = map.get(random);
            cur = cur.next;
            node = node.next;
        }
        return root.next;
    }
}
