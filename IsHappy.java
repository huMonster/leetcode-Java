package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 202 IsHappy 快乐数
 * @Author Monster
 * @Date 2020/8/8 18:18
 * @Version 1.0
 */
public class IsHappy {

    /**
     * 利用set集合无重复特点匹配结果集： 3ms 36.9MB
     * 改进：使用list代替set 2ms 36.7MB
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        //Set<Integer> record = new TreeSet<>();
        List<Integer> record = new ArrayList<>();
        int result = 0;
        while (true) {
            while (n != 0) {
                int num = n % 10;
                result += num * num;
                n /= 10;
            }
            if (result == 1) {
                return true;
            } else if (record.contains(result)) {
                return false;
            } else {
                record.add(result);
                n = result;
                result = 0;
            }
        }
    }

    /**
     * 通过运算，得出非快乐数规律 1ms 36.7MB
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int result = 0;
        while(true) {
            while (n != 0) {
                int num = n % 10;
                result += num * num;
                n /= 10;
            }
            if (result == 1) {
                return true;
            }else if (result == 4 || result == 16 || result == 37 || result == 58  || result == 89 || result == 145 || result == 42  || result == 20) {
                return false;
            } else {
                n = result;
                result = 0;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));
    }
}
