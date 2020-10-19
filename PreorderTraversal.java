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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new PreorderTraversal().preorderTraversal(root));
    }
}
