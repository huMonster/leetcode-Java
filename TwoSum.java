package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 1 TwoSum 给定target,在数组中找到两个数字和为target,输出下标
 * @Author Monster
 * @Date 2020/6/21 16:09
 * @Version 1.0
 */
public class TwoSum {
    /**
     * 暴力解法
     * 时间复杂度为 O(n^2)
     */
    public int[] twoSum(int[] nums, int target) {

        // break可以终止单循环，但如果是双重循环，break后外层循环依旧可以执行
        // 1.标签方法来结束双层for循环
        // 2.设置一个变量来标记
        // boolean isBreak = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 对撞指针 l&r双指针
     * 必要条件是：【有序】
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(1)
     *
     * @param nums
     * @param target
     */
    public int[] twoSum2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                return new int[]{l, r};
            }
        }
        return null;
    }

    /**
     * 利用hash表是否存在来判断
     * 对是否有序不要求
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i])) {
                return new int[]{record.get(target - nums[i]), i};
            }
            record.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 4};
        int target = 6;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }
}
