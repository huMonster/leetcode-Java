package com.algorithm.leetcode;

/**
 * @Description MinSubArrayLen
 * @Author Monster
 * @Date 2020/6/23 20:35
 * @Version 1.0
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums){
        if( s == 0 || nums.length <= 0){
            return 0;
        }
        // 初始化时j = -1，使得[l,r]不包含任何元素
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while(l < nums.length){
            if(r + 1 < nums.length && sum < s){
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s){
                res = res > r-l+1 ? r-l+1 : res;
            }
        }
        if(res == nums.length + 1){
            return 0;
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3,2};
        int s = 7;
        System.out.println(new MinSubArrayLen().minSubArrayLen(s, nums));
    }
}
