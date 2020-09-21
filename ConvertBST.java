package com.algorithm.leetcode;

import com.test.utils.TreeNode;

/**
 * @Description 538 ConvertBST 把二叉搜索树转换为累加树
 * @Author Monster
 * @Date 2020/9/21 14:17
 * @Version 1.0
 */
public class ConvertBST {
    // 累加结果
    int count = 0;

    /**
     * 二叉搜索树的特点: 如果左、右子树存在，则有左子树的值小于当前节点的值， 右子树的值大于当前节点的值
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        // 利用中序遍历得到一个从小到大排列的值集，那么先遍历右子树得到一个从大到小的值集，然后累加结果即可
        if(root != null){
            convertBST(root.right);
            count += root.val;
            root.val = count;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode.printNode(new ConvertBST().convertBST(root));
    }
}
