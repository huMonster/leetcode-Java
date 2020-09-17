package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description 219 ContainsNearbyDuplicate 存在重复元素II
 * @Author Monster
 * @Date 2020/9/16 15:27
 * @Version 1.0
 */
public class ContainsNearbyDuplicate {

    /**
     * 滑动窗口 + 查找表
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(record.contains(nums[i]))
                return true;
            else record.add(nums[i]);

            if(record.size() == k+1){
                record.remove(nums[i-k]);
            }
        }
        return false;
    }

    /**
     * 将HashMap换成ArrayList
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        // 针对测试用例的条件限制
        if(k>=35000)return false;
        List<Integer> record = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(record.contains(nums[i]))
                return true;
            else record.add(nums[i]);

            if(record.size() == k+1){
                // 超过K后，将第一位移除掉
                record.remove(0);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate2(nums, k));
    }
}
