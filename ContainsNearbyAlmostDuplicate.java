package com.algorithm.leetcode;

import java.util.TreeSet;

/**
 * @Description 220 ContainsNearbyAlmostDuplicate 存在重复元素III
 * @Author Monster
 * @Date 2020/9/17 15:26
 * @Version 1.0
 */
public class ContainsNearbyAlmostDuplicate {

    /**
     * 滑动窗口 + 查找表
     * 根据题意知，查找表中存在一个元素X，使得当前元素nums[i]满足 nums[i] - t <= x <= nums[i] + t，返回 true，否则返回 false;
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 找到record中大于等于(long)nums[i] - t的集合的最小元素
            Long ceiling = record.ceiling((long)nums[i] - t);
            // 条件判断
            if(ceiling != null && ceiling <= (long)nums[i] + t){
                return true;
            }
            record.add((long)nums[i]);
            if(record.size() == k + 1){
                record.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int[] nums = {1,5,9,1,5,9};
        int[] nums = {2147483640,2147483641};
//        int k = 2, t = 3;
//        int k = 3, t = 0;
        int k = 1, t = 100;
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums, k, t));
    }
}
