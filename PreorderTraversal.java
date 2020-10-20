package com.algorithm.leetcode;

import com.test.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 144 PreorderTraversal 二叉树的前序遍历
 * @Author Monster
 * @Date 2020/10/19 16:16
 * @Version 1.0
 */
public class PreorderTraversal {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        preorder(root, record);
        return record;
    }
    private void preorder(TreeNode root, List<Integer> record){
        if(root != null){
            record.add(root.val);
            preorder(root.left, record);
            preorder(root.right, record);
        }
    }

    /**
     * 非递归 -- 使用栈
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        if(root == null) return record;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            record.add(root.val);
            if(root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }

        }
        return record;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new PreorderTraversal().preorderTraversal(root));
    }
}
