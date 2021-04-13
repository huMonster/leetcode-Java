package com.algorithm.leetcode;

/**
 * @Description 509 斐波拉契数列
 * @Author Monster
 * @Date 2021/4/13 10:56
 * @Version 1.0
 */
public class Fib {
    /**
     * 递归： F(n) = F(n - 1) + F(n - 2)
     *
     * @param n F(n)
     * @return
     */
    public static int recursion(int n){
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
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
    
    public static void main(String[] args) {
        System.out.println(recursion(9));
        System.out.println(nonRecursion(9));
    }
}
