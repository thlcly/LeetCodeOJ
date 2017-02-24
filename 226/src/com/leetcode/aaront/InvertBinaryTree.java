package com.leetcode.aaront;


/**
 * @author tonyhui
 * @since 17/2/24
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        invertTree(root);
        return root;
    }

    /**
     * 思路: 递归将left子树和right子树对调
     */
    public void invert(TreeNode node) {
        if (node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invert(node.left);
        invert(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}