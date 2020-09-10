package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 77 Combine 组合
 * @Author Monster
 * @Date 2020/9/8 9:36
 * @Version 1.0
 */
public class Combine {
    List<List<Integer>> record = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n , k);
        return record;
    }

    /**
     * 递归方法
     *
     * @param start  开始位置
     * @param n      结束位置
     * @param k      每个组合的元素个数
     */
    private void dfs(int start, int n, int k) {
        if (k == 0) {
            record.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            dfs(i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 3));
    }
}
