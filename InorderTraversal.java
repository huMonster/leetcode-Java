package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 94 InorderTraversal 二叉树的中序遍历
 * @Author Monster
 * @Date 2020/9/14 14:42
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InorderTraversal {

    // 存放中序遍历的结果
    List<Integer> record = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            record.add(root.val);
            inorderTraversal(root.right);
        }
        return record;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null ) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                record.add(root.val);
                root = root.right;
            }
        }
        return record;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new InorderTraversal().inorderTraversal2(root));
    }
}
