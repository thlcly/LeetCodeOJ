package com.leetcode.aaront;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonyhui
 * @since 2018/1/22
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args){

    }

    // 传统解法
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean positiveSeq = true;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(nodes.size() > 0) {
            List<Integer> values = new ArrayList<>();
            if(positiveSeq) {
                for(TreeNode node : nodes) {
                    values.add(node.val);
                }
            } else {
                for(int i = nodes.size() - 1;i>=0;i--) {
                    values.add(nodes.get(i).val);
                }
            }
            list.add(values);
            positiveSeq = !positiveSeq;
            List<TreeNode> newNodes = new ArrayList<>();
            for(TreeNode node : nodes) {
                if(node.left!=null)
                    newNodes.add(node.left);
                if(node.right!=null)
                    newNodes.add(node.right);
            }
            nodes = newNodes;
        }
        return list;
    }

    // 使用DFS, 遍历的时候如果list.size() <= level所以这个层级的列表还没有创建(向下遍历的时候, 当回溯的时候就会有list.size()>level了), 则创建这个层级的列表. 后面的操作根据level从list中获取指定层级的列表
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }


    public void traverse(TreeNode curr, List<List<Integer>> list, int level) {
        if(curr == null) return;

        // 初始化每一个层级的列表
        if(list.size() <= level) {
            list.add(new ArrayList<>());
        }

        List<Integer> values = list.get(level);
        if(level % 2 == 0) values.add(curr.val); // 偶数层正序
        else values.add(0, curr.val);      // 奇数层逆序

        traverse(curr.left, list, level + 1);
        traverse(curr.right, list, level + 1);
    }
}
