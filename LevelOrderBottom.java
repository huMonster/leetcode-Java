package com.algorithm.leetcode;

import com.test.utils.TreeNode;

import java.util.*;

/**
 * @Description 107 LevelOrderBottom 二叉树的层次遍历II
 * @Author Monster
 * @Date 2020/12/1 11:05
 * @Version 1.0
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        // 声明LinkedList
        LinkedList<List<Integer>> record = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = null;
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();

            list = new ArrayList<>();
            while (count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                --count;
            }
            // 使用LinkedList的addFirst方法，每次都从头部插入
            record.addFirst(list);
        }
        return record;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(new LevelOrderBottom().levelOrderBottom(root));
    }
}
