package com.leetcode.aaront;


/**
 * @author tonyhui
 * @since 17/2/28
 */
public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        return traverse(root, Integer.MAX_VALUE);
    }

    /**
     * 思路: 根据BSF树的特性: 一个节点的左子树的最右节点(如果存在)和右子树的最左节点(如果存在)是和这个最接近的两个节点,
     *      所以这个题目就转换成查找每个节点的所有的左子树的最右节点(如果存在)和右子树的最左节点(如果存在), 然后计算两者的值, 得到的就是和这个
     *      节点的val最接近的节点的差值(min(node1)), 然后找到所有的节点的min(node)集合中的最小值就是题目的解
     */
    public int traverse(TreeNode node, int min) {
        if (node == null) return min;
        int parentLeftTreeDiff = Integer.MAX_VALUE;
        int parentRightTreeDiff = Integer.MAX_VALUE;
        TreeNode leftTreeRightest = findLeftTreeRightest(node);
        TreeNode rightTreeLeftest = findRightTreeLeftest(node);
        if(leftTreeRightest != null) parentLeftTreeDiff = Math.abs(node.val - leftTreeRightest.val);
        if(rightTreeLeftest != null) parentRightTreeDiff = Math.abs(node.val - rightTreeLeftest.val);
        int diffMin = (parentLeftTreeDiff > parentRightTreeDiff ? parentRightTreeDiff : parentLeftTreeDiff);
        min = diffMin > min ? min : diffMin;
        int leftMin = traverse(node.left, min);
        int rightMin = traverse(node.right, min);
        return leftMin > rightMin ? rightMin : leftMin;
    }

    // 查找左子树最右节点
    public TreeNode findLeftTreeRightest(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return null;
        TreeNode left = node.left;
        while (left.right != null) {
            left = left.right;
        }
        return left;
    }

    // 查找右子树最左节点
    public TreeNode findRightTreeLeftest(TreeNode node) {
        if (node == null) return null;
        if (node.right == null) return null;
        TreeNode right = node.right;
        while (right.left != null) {
            right = right.left;
        }
        return right;
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
