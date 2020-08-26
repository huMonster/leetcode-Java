package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 18 FourSum 四数之合
 * @Author Monster
 * @Date 2020/8/21 17:14
 * @Version 1.0
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> record = new ArrayList<>();
        if(nums == null || nums.length < 4) return record;
        Arrays.sort(nums);
        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4];
        // 筛选出不存的数
        if(minValue > target || maxValue < target) return record;
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 &&  nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 跳过重复的数
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;
                minValue = nums[i] + nums[j] + nums[l] + nums[l + 1];
                maxValue = nums[i] + nums[j] + nums[r] + nums[r - 1];
                // 筛选出不存的数
                if (minValue > target || maxValue < target) continue;
                int newTarget = target - nums[i];
                while(l < r){
                    if(nums[l] + nums[r] > newTarget - nums[j]) r--;
                    else if(nums[l] + nums[r] < newTarget - nums[j]) l++;
                    else {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        record.add(list);
                        // 左指针右移 跳过重复的数
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        // 右指针左移 跳过重复的数
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
            
        }
        return record;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(fourSum(nums, 0));
    }
}
