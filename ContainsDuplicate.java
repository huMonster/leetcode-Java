package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description 217 ContainsDuplicate 存在重复元素
 * @Author Monster
 * @Date 2020/9/17 11:17
 * @Version 1.0
 */
public class ContainsDuplicate {
    /**
     * 哈希表
     *  时间复杂度 O(n)
     *  空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])){
                return true;
            } else {
                record.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * 排序在对比
     *  时间复杂度：O(nlogn)
     *  空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
//        int[] nums = {1,2,3,4};
        System.out.println(new ContainsDuplicate().containsDuplicate2(nums));
    }
}
