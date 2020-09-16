package com.algorithm.leetcode;

/**
 * @Description 226 InvertTree 翻转二叉树
 * @Author Monster
 * @Date 2020/9/16 9:36
 * @Version 1.0
 */

public class InvertTree {

    /**
     * 分析发现二叉树的前序遍历就是翻转二叉树的后序遍历的倒序，考虑使用栈的特点来存前序遍历的结果，然后依次输出变为翻转二叉树，
     * 但是实际却无法通过一个前序遍历恢复二叉树，所以想到了第二种方法，使用递归交换左右子树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode tr = new InvertTree().invertTree(root);
        System.out.println(tr);
    }
}
