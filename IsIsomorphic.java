package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 205 IsIsomorphic 同构字符串
 * @Author Monster
 * @Date 2020/8/15 20:35
 * @Version 1.0
 */
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t){
        if(s.isEmpty() || t.isEmpty()){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Character> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(record.containsKey(s.charAt(i))){
                if(!record.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            } else {
                if(record.containsValue(t.charAt(i))){
                    return false;
                } else {
                    record.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(sArr[c1] == tArr[c2]){
                sArr[c1] = i + 1;
                tArr[c2] = i + 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String s = "paper", t = "title";
        //String s = "", t = "";
        String s = "13", t = "42";
        System.out.println(new IsIsomorphic().isIsomorphic2(s, t));
    }
}
