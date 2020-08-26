package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 290 WordPattern 单词规律
 * @Author Monster
 * @Date 2020/8/9 19:52
 * @Version 1.0
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.isEmpty() || str.isEmpty()) {
            return false;
        }
        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(patterns.length != strs.length){
            return false;
        }
        Map<Character, String> record = new HashMap();
        for (int i = 0; i < patterns.length; i++) {
            if(record.containsKey(patterns[i])){
                if(!record.get(patterns[i]).equals(strs[i])){
                    return false;
                }
            } else {
                if(record.containsValue(strs[i])){
                    return false;
                } else {
                    record.put(patterns[i], strs[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }
}
