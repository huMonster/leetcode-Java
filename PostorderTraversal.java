package com.algorithm.leetcode;

import com.test.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 145 PostorderTraversal 二叉树的后序遍历
 * @Author Monster
 * @Date 2020/9/29 9:47
 * @Version 1.0
 */
public class PostorderTraversal {

    // 存放后序遍历结果集
    List<Integer> record = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            record.add(root.val);
        }
        return record;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(root != null && !stack.isEmpty()){
            root = stack.pop();
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
            record.add(0, root.val);
        }
        return record;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new PostorderTraversal().postorderTraversal2(root));
    }
}
