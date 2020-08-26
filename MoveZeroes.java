package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 283 MoveZeroes 移动零
 * @Author Monster
 * @Date 2020/6/18 11:31
 * @Version 1.0
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = (int) list.get(i);
        }

        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public void moveZeroes2(int[] nums) {
        // nums中,[0, j)的元素均为非0元素
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        // 将[j, nums.length)的元素置零
        while(j < nums.length){
            nums[j++] = 0;
        }
    }
    public void moveZeroes3(int[] nums) {
        // nums中,[0, j)的元素均为非0元素
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                // 对非零数组判断（如果数组没有零的元素，会产生无意义的数据交换）
                if( i != j){
                    int temp = nums[j];
                    nums[j++] = nums[i];
                    nums[i] = temp;
                } else {
                    j++;
                }

            }
        }
    }
}
