package com.algorithm.leetcode;

import com.test.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 103 ZigzagLevelOrder 二叉树的锯齿形层次遍历
 * @Author Monster
 * @Date 2020/12/1 15:12
 * @Version 1.0
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        // 存放结果
        List<List<Integer>> record = new ArrayList<>();
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将root加入队列
        queue.add(root);
        // 临时层级相同的节点的值
        LinkedList<Integer> list = null;
        // 是否反转
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            list = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                // 插入当前第一位
                if(isReverse) list.addFirst(node.val);
                else list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            // 如果当前不反转，则下次反转，同理
            isReverse = !isReverse;
            record.add(list);
        }
        return record;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }
}
