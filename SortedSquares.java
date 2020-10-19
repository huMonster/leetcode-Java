package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Description 977 SortedSquares 有序数组的平方
 * @Author Monster
 * @Date 2020/10/19 10:09
 * @Version 1.0
 */
public class SortedSquares {
    /**
     * 双指针比较，找出最大的平方值存入数组中
     * 
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] record = new int[len];
        int i = len - 1, l = 0, r = i;
        while (l <= r) {
            if (A[r] * A[r] > A[l] * A[l]) {
                record[i--] = A[r] * A[r--];
            } else {
                record[i--] = A[l] * A[l++];
            }
        }
        return record;
    }

    public int[] sortedSquares2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        int[] arrays = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(new SortedSquares().sortedSquares(arrays)));
    }
}
