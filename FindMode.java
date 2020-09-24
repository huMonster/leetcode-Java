package com.algorithm.leetcode;

import com.test.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 501 FindMode 二叉搜索树中的众数
 * @Author Monster
 * @Date 2020/9/24 9:56
 * @Version 1.0
 */
public class FindMode {
    // 前一个值， 当前值相同的次数， 最大相同次数
    int preVal = 0, curTimes = 0, maxTimes = 0;
    // 记录结果
    List<Integer> record = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int len = record.size();
        int[] result = new int[len];
        // 将List转换为Array
        for (int i = 0; i < len; i++) {
            result[i] = record.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            // 判断当前值是否等于上一个值
            if(preVal == root.val){
                curTimes++;
            } else {
                preVal = root.val;
                curTimes = 1;
            }

            // 判断相同值的次数是否大于当前最大次数
            if(curTimes > maxTimes){
                // 清空List
                record.clear();
                record.add(root.val);
                maxTimes = curTimes;
            } else if(curTimes == maxTimes){
                record.add(root.val);
            }
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);

        System.out.println(Arrays.toString(new FindMode().findMode(root)));
    }
}
