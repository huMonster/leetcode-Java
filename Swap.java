package com.algorithm.leetcode;

/**
 * @Description 75 swap 颜色分类
 * @Author Monster
 * @Date 2020/6/19 21:31
 * @Version 1.0
 */
public class Swap {

    /**
     * 暴力破解
     */
    public void swap(int[] nums) {
        int[] sorts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            sorts[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            // [0,0,0,0] ---- [0, 4)
            if(i < sorts[0]){
                nums[i] = 0;
            } else if(i < sorts[1] + sorts[0]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }


    /**
     * 交换函数
     */
    private void swapFunction(int[] nums, int index, int index1) {
        int temp = nums[index];
        nums[index] = nums[index1];
        nums[index1] = temp;
    }

    /**
     *  三路快排
     *  时间复杂度 O(n)
     *  空间复杂度 O(1)
     * @param nums
     */
    public void swap2(int[] nums) {
        // 为0的位置区间[0, zero]，在初始的情况下，zero = -1即[0, -1]为一个无效的区间
        // two同理
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two;) {
            if (nums[i] == 0) {
                swapFunction(nums, ++zero, i++);
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                // 最后判断一下，以防用户输入大于2的数，严谨!
                swapFunction(nums, i, --two);
            }
        }
    }
}
