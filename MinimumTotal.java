package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 120 MinimumTotal 三角形最小路径和
 * @Author Monster
 * @Date 2021/5/7 13:52
 * @Version 1.0
 */
public class MinimumTotal {
    private static int[][] record;

    /**
     * 递归
     *
     * @param triangle
     * @return
     */
    private static int recursion(List<List<Integer>> triangle) {
        record = new int[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j) {

        if (i == triangle.size()) {
            return 0;
        }
        if (record[i][j] != 0) {
            return record[i][j];
        }
        return record[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 动态规划
     *
     * @param triangle
     */
    public static int dp(List<List<Integer>> triangle){
        int len = triangle.size();
        int[] record = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i ; j++) {
                record[j] = Math.min(record[j], record[j+1]) + triangle.get(i).get(j);
            }
        }
        return record[0];
    }
    public static void main(String[] args) {
        List<List<Integer>> record = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        record.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        record.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(6);
        l3.add(7);
        record.add(l3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(8);
        l4.add(9);
        l4.add(10);
        l4.add(11);
        record.add(l4);
        System.out.println(dp(record));
    }
}
