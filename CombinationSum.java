package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 39 CombinationSum 组合总和
 * @Author Monster
 * @Date 2020/9/9 9:44
 * @Version 1.0
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, 0, new ArrayList<Integer>());
        return result;
    }

    /**
     * 回溯算法（类似题目：39 40 46 47 78 90）
     * 关键在于:不合适就退回上一步
     * @param candidates 数组
     * @param target     目标
     * @param result     结果集
     * @param start      起始位置
     * @param temp       中间结果集
     */
    private void backtrack(int[] candidates, int target, List<List<Integer>> result, int start, ArrayList<Integer> temp) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], result, i, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }
}
