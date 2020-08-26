package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 15 ThreeSum
 * @Author Monster
 * @Date 2020/8/19 15:13
 * @Version 1.0
 */
public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums, int target){
        List<List<Integer>> record = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            l = i + 1;
            r = nums.length - 1;
            while(l < r){
                if(nums[l] + nums[r] > target-nums[i]){
                    //while(l < r && nums[r] == nums[--r]);
                    --r;
                } else if(nums[l] + nums[r] < target-nums[i]){
                    //while ( l < r && nums[l] == nums[++l]);
                    ++l;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    record.add(list);
                    while(l < r && nums[r] == nums[--r]);
                    while ( l < r && nums[l] == nums[++l]);
                }
            }
        }
        return record;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(solution(nums, -2));
    }
}
