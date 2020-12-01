package com.algorithm.leetcode;

import com.test.utils.TreeNode;

import java.util.*;

/**
 * @Description 102 LevelOrder 二叉树的层序遍历
 * @Author Monster
 * @Date 2020/12/1 9:59
 * @Version 1.0
 */
public class LevelOrder {

    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> record = new ArrayList<>();
        List<Integer> list = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            list = new ArrayList<>();
            while (count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                count--;
            }
            record.add(list);
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
        System.out.println(new LevelOrder().levelOrder(root));
    }
}
