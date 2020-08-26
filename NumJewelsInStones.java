package com.test.leetcode;

import java.util.Set;
import java.util.TreeSet;
/**
 * @Description 771 NumJewelsInStones 宝石与石头
 * @Author Monster
 * @Date 2020/8/11 10:52
 * @Version 1.0
 */
public class NumJewelsInStones {
    /**
     * 利用set集合无重复特性
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S){
        Set record = new TreeSet();
        for (char ch : J.toCharArray()) {
            record.add(ch);
        }
        int count = 0;
        for (char stone : S.toCharArray()) {
            if(record.contains(stone)){
                count++;
            }
        }
        return count;
    }

    /**
     * 调用indexOf()方法
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones2(String J, String S){
        char[] chs = S.toCharArray();
        int count = 0;
        for ( char ch : chs) {
            if(J.indexOf(ch) != -1){
                count++;
            }
        }
        return  count;
    }
    public static void main(String[] args) {
        String j = "z", s = "zzzzZ";
        System.out.println(new NumJewelsInStones().numJewelsInStones(j, s));
    }
}
