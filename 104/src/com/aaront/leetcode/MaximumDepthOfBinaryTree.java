package com.aaront.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tonyhui
 * @since 16/9/30
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args){

    }

    /**
     * 思路: 层级遍历二叉树, 每一次遍历都拿到当前层的所有节点,如果节点集合不为空则depth++,否则说明到叶子节点了,跳出, 此时的depth就是最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> nodes = new ArrayList<>(1);
        nodes.add(root);
        map.put(1, nodes);
        int depth = 1;
        while(true) {
            List<TreeNode> levelNodes = map.get(depth);
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            levelNodes.forEach(node -> {
                if(node.left != null) nextLevelNodes.add(node.left);
                if(node.right != null) nextLevelNodes.add(node.right);
            });
            if(!nextLevelNodes.isEmpty()) {
                depth++;
                map.put(depth, nextLevelNodes);
            } else {
                break;
            }

        }
        return depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}