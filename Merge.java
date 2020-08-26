package com.algorithm.leetcode;
/**
 * @Description 88 Merge 合并两个有序数组
 * @Author Monster
 * @Date 2020/6/20 16:50
 * @Version 1.0
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m--+--n;
        while(n>=0) {
            nums1[i--] = m>=0 && nums1[m]>nums2[n] ? nums1[m--] : nums2[n--];
        }
    }
}
