package com.test.leetcode;

import java.util.Arrays;

/**
 * @Description ThreeSumClosest 最接近的三数之和
 * @Author Monster
 * @Date 2020/8/24 17:48
 * @Version 1.0
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复
//            if(i > 0 && nums[i] == nums[i-1]){
//                continue;
//            }
            int l = i + 1, r =  nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) {
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(closest - target)){
                    closest = sum;
                }
                if(sum < target){
                    // 左指针右移，判断重复
                    // while (l < r && nums[l] == nums[l+1]) l++;
                    l++;
                } else {
                    // 右指针左移，判断重复
                    // while (l < r && nums[r] == nums[r-1]) r--;
                    r--;
                }
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,-1,1,-4, 4};
        int target = 7;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
