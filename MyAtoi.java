package com.algorithm.leetcode;

/**
 * @Description 8 MyAtoi 将字符串转换为整数（atoi）
 * @Author Monster
 * @Date 2020/9/7 9:57
 * @Version 1.0
 */
public class MyAtoi {

    public int myAtoi(String str) {
        int point = 0;
        int len = str.length();
        char[] chs = str.toCharArray();
        while (point < len && chs[point] == ' ') {
            point++;
        }
        if (len == point) {
            return 0;
        }
        boolean sign = true;
        if (chs[point] == '+') {
            point++;
        } else if (chs[point] == '-') {
            point++;
            sign = false;
        } else if (!Character.isDigit(chs[point])) {
            return 0;
        }
        int res = 0;
        while (point < len && Character.isDigit(chs[point])) {
            int digit = chs[point] - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            point++;
        }
        return sign ? res : -res;
    }

    public static void main(String[] args) {
        String str = "      -42";
//        String str = "-91283472332";
//        String str = "  ";
//        String str = "+-2";
//        String str = "42";
//        String str = "aaa 123"; // return 0
        System.out.println(new MyAtoi().myAtoi(str));
    }
}
