package com.algorithm.leetcode;

/**
 * @Description 28 StrStr 实现strStr函数：寻找字串，输出第一个位置 (从0开始)
 * @Author Monster
 * @Date 2020/6/29 20:11
 * @Version 1.0
 */
public class StrStr {
    private int[] getNext(char[] p) {
        int[] next = new int[p.length];
        int i = 0, j = -1;
        next[0] = 0;
        while (i < p.length - 1) {
            if (j == -1 || p[i] == p[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
    /**
     * KMP算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if(haystack.length() > 0){
            int i = 0, j = -1;
            int[] next = getNext(haystack.toCharArray());
            while (i < haystack.length() - 1) {
                if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                    ++i;
                    ++j;
                    if (j == needle.length()) {
                        return i - j;
                    }
                } else {
                    j = next[j];
                }
            }
        }
        return -1;
    }

    /**
     * 直接使用indexOf()函数
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(new StrStr().strStr(haystack, needle));
    }
}
