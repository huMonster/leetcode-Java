package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 454 FourSumCount 四数相加II
 * @Author Monster
 * @Date 2020/8/31 17:40
 * @Version 1.0
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                record.put(A[i] + B[j], record.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if(record.containsKey(-C[i] - D[j])){
                    count += record.get(-C[i] - D[j]);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(new FourSumCount().fourSumCount(A, B, C, D));
    }
}
