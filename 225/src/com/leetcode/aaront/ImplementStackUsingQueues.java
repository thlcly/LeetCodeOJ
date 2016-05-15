package com.leetcode.aaront;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tonyhui
 * @since 16/5/15
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args){

        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.top();

    }

}

/**
 * 使用队列实现栈
 */
class MyStack {
    private Queue<Integer> in = new ArrayDeque<>();
    private Queue<Integer> out = new ArrayDeque<>();

    // Push element x onto stack.
    public void push(int x) {
        in.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(in.size() > 1) {
            out.offer(in.poll());
        }
        in.poll();
        while (out.size() > 0) {
            in.offer(out.poll());
        }
    }

    // Get the top element.
    public int top() {
        while(in.size() > 1) {
            out.offer(in.poll());
        }
        int ele = in.poll();
        out.offer(ele);
        while (out.size() > 0) {
            in.offer(out.poll());
        }
        return ele;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return in.isEmpty();
    }
}