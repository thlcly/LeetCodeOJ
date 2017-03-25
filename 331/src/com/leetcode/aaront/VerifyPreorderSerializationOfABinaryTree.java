package com.leetcode.aaront;

import java.util.Stack;

/**
 *
 * 思路: 使用栈的特性, 每遍历到2个"#"(说明是叶子节点), 就将其和根节点转换成一个"#", 以此类推
 *       更好的方法: 可以在数的出度和入度上作文章
 *
 * @author tonyhui
 * @since 17/3/24
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] split = preorder.split(",");
        for (int i = 0, len = split.length; i < len; i++) {
            String ele = split[i];
            stack.push(ele);
            while(repeat(stack)) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
                if(stack.size() == 1 && stack.peek().equals("#") && i + 1 < len) return false;
            }
        }
        return stack.size() == 1 &&  stack.pop().equals("#");
    }

    public boolean repeat(Stack<String> stack) {
        if(stack.isEmpty()) return false;
        if(stack.size() < 3) return false;

        String left = stack.pop();
        String right = stack.pop();
        String root = stack.pop();
        stack.push(root);
        stack.push(right);
        stack.push(left);
        if(left.equals("#") && right.equals("#") && !root.equals("#")) {
           return true;
        }
        return false;
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(v.isValidSerialization("#,#,#"));
    }
}
