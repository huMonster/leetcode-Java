package com.algorithm.leetcode;

/**
 * @Description 509 斐波拉契数列
 * @Author Monster
 * @Date 2021/4/13 10:56
 * @Version 1.0
 */
public class Fib {

    // 题目限制条件为[0, 30]，共31个数
    private static int[] record = new int[31];
    /**
     * 递归： F(n) = F(n - 1) + F(n - 2)
     * 问题：大量重复计算
     * 优化：先判断当前位置是否计算过，如果没有，则先计算在存储，如果有，直接返回计算过的值
     *
     * @param n F(n)
     * @return
     */
    public static int recursion(int n){
        if(n <= 1){
            return n;
        }
        if(record[n] == 0){
            record[n] = recursion(n - 1) + recursion(n - 2);
        }
        return record[n];
    }

    /**
     * 非递归：三个指针 first -> F(n-2)
     *               second -> F(n-1)
     *               result -> F(n) += F(n - 2)
     * @param n
     * @return
     */
    public static int nonRecursion(int n){
        int first = 0;
        if(n == 0){
            return first;
        }
        int second = 1;
        int result = 1;
        while (n-- > 2){
            first = second;
            second = result;
            result += first;
        }
        return result;
    }

    /**
     * 动态规划
     * @param n
     */
    public static int dp(int n){
        if(n <= 1){
            return n;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(recursion(n));
    }
}
