package com.algorithm.leetcode;

/**
 * @Description 70 ClimbStairs  爬楼梯
 * @Author Monster
 * @Date 2021/4/22 15:03
 * @Version 1.0
 */
public class ClimbStairs {
    // 记录运行的次数
    private static int count = 0;
    // 运算记录
    private static int[] record;
    // 返回值是int, 当n = 46时已经是int能表示的最大结果了
//    private static int[] record = new int[47];
    // 递归：该题类似斐波拉契数列
    public static int recursion(int n) {
        count++;
        if(n <= 1) return 1;
        if(record[n] == 0){
            record[n] = recursion(n - 1) + recursion(n - 2);
        }
        return record[n];
    }

    // 动态规划
    public static int dp(int n) {
        record[0] = 1;
        record[1] = 1;
        for (int i = 2; i <= n ; i++) {
            record[i] = record[i - 1] + record[i - 2];
        }
        count = n - 1;
        return record[n];
    }

    public static void main(String[] args) {
        int n = 20;
        // 初始化数组
        record = new int[n + 1];
        System.out.println("结果：" + dp(n));
        System.out.println("次数：" + count);
    }
}