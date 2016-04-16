package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 16/4/16
 */
public class SameTree {
    public static void main(String[] args){
        //System.out.println(isSameTree());
    }

    /**
     * 思路: 使用一次遍历判断2个树是否相等,分别判断树的结构以及节点的值
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
