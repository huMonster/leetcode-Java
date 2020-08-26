package com.algorithm.leetcode;

import java.util.*;

/**
 * @Description 438 FindAnagrams 找到字符串中所有字母异位词
 * @Author Monster
 * @Date 2020/6/27 14:33
 * @Version 1.0
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p){
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int[] needs = new int[26];
        int[] freq = new int[26];
        int left = 0, right = 0, count = 0;

        for(char ch : p.toCharArray()){
            needs[ch - 'a'] ++;
        }

        while(right < s.length()){
            int n1 = needs[s.charAt(right) - 'a'];
            if(n1 > 0 && ++freq[s.charAt(right) - 'a'] <= n1){
                count ++;
            }
            while(count == p.length()){
                if(right- left + 1 == p.length()){
                    list.add(left);
                }
                int n2 = needs[s.charAt(left) - 'a'];
                if(n2 > 0 && --freq[s.charAt(left) - 'a'] < n2){
                    count --;
                }
                left++;
            }
            right ++;
        }
        return list;
    }
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(new FindAnagrams().findAnagrams(s, p));
    }
}
