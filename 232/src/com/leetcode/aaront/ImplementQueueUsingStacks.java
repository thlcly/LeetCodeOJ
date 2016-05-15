package com.leetcode.aaront;

import java.util.Stack;

/**
 * @author tonyhui
 * @since 16/5/15
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();

    }
}

class MyQueue {
    // 入队列
    private Stack<Integer> in = new Stack<>();
    // 出队列
    private Stack<Integer> out = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        // 因为in.size()的长度是可变的,所以可以利用这个特性进行循环条件的判断,而不用重新定一个一个变量
        while (in.size() > 1) {
            out.push(in.pop());
        }
        in.pop();
        while(out.size() > 0) {
            in.push(out.pop());
        }
    }

    // Get the front element.
    public int peek() {
        while(in.size() > 0) {
            out.push(in.pop());
        }
        int ele = out.peek();
        while(out.size() > 0) {
            in.push(out.pop());
        }
        return ele;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.empty();
    }
}