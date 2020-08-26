package com.algorithm.leetcode;

/**
 * @Description RemoveDuplicates 去除重复数字，每个数字最多出现两次
 * @Author Monster
 * @Date 2020/6/15 20:22
 * @Version 1.0
 */
public class RemoveDuplicates {

    /**
     * 利用第 n 位 > 第 n-x 位的规则进行判断重复x次的数组
     * @param nums
     */
    public void removeDuplicates(int[] nums) {
        // 新数组的长度
        int j = 0;
        for (int n : nums) {
            if (j < 2 || n > nums[j-2]) {
                nums[j++] = n;
            }
        }
        for (int i = 0; i < j; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3};
        new RemoveDuplicates().removeDuplicates(nums);
    }
}
