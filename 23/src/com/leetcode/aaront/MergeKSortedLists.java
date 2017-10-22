package com.leetcode.aaront;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tonyhui
 * @since 2017/10/22
 */
public class MergeKSortedLists {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args){
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(1);
        //n1.next = n2;
        //n2.next = n3;

        ListNode[] nodes = new ListNode[]{n4, n1};
        MergeKSortedLists m = new MergeKSortedLists();
        m.mergeKLists(nodes);
    }

    /**
     * 思路: 类似快排的思想, 两两合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    /**
     * 将链表进行分解, 然后排序
     */
    public ListNode partion(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];
        if(start < end) {
            int mid = (end - start) / 2 + start;
            ListNode l1 = partion(lists, start, mid);
            ListNode l2 = partion(lists, mid + 1, end);
            return mergeTwoLists(l1, l2);
        }
        return null;
    }

    /**
     * 排序两个链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            } else if(l2 == null) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                int v1 = l1.val;
                int v2 = l2.val;
                if (v1 > v2) {
                    tail.next = l2;
                    tail = tail.next;
                    l2 = l2.next;
                } else {
                    tail.next = l1;
                    tail = tail.next;
                    l1 = l1.next;
                }
            }
        }
        return head.next;
    }

    /**
     * 思路: 使用优先队列
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//        for(ListNode node : lists) {
//            if(node != null) {
//                queue.add(node);
//            }
//        }
//
//        ListNode head = new ListNode(0);
//        ListNode tail = head;
//
//        while(!queue.isEmpty()) {
//            ListNode node = queue.poll();
//            tail.next = node;
//            tail = node;
//            if(node.next != null) {
//                queue.add(node.next);
//                node.next = null;
//            }
//        }
//        return head.next;
//    }
    /**
     * 这个做法会超时
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        int max ;
//        while((max = getMax(lists)) != -1) {
//            ListNode node = lists[max];
//            lists[max] = lists[max].next;
//            cur.next = node;
//            cur = node;
//            node.next = null;
//        }
//
//        return head.next;
//    }
//
//    public int getMax(ListNode[] lists) {
//        int max = 0;
//        boolean flag = false;
//        for(int i = 0;i<lists.length;i++) {
//            if(lists[i] == null) continue;
//            if(lists[max] == null) max = i;
//            flag = true;
//            if(lists[i].val < lists[max].val) max = i;
//        }
//        if(flag) return max;
//        return -1;
//    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
