package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 16/2/4
 */
public class AddTwoNumbers {

   public static void main(String[]args){
       ListNode l1 = new ListNode(0);
       l1.next = null;
       ListNode l2 = new ListNode(1);
       l2.next = null;
       addTwoNumbers(l1, l2);
   }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        while(l1 != null || l2 != null){
            if(l1 != null) {
                list1.add(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                list2.add(l2.val);
                l2 = l2.next;
            }
        }
        int rest = 0;
        int carry = 0;
        List<ListNode> list3 = new ArrayList<>();
        int len1 = list1.size();
        int len2 = list2.size();
        for(int i = 0, length = len1 > len2 ? len1 : len2 ; i<length; i++){
            int val1 = 0;
            int val2 = 0;
            if(i < len1) val1 = list1.get(i);
            if(i < len2) val2 = list2.get(i);
            int sum = val1 + val2;
            sum += carry;
            rest = sum % 10;
            carry = sum / 10;
            list3.add(new ListNode(rest));
        }
        if(carry != 0){
            list3.add(new ListNode(carry));
        }
        int len3 = list3.size();
        for(int i = 0;i<len3;i++){
            if(i == len3 - 1)list3.get(i).next = null;
            else list3.get(i).next = list3.get(i+1);
        }

        return list3.get(0);

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
