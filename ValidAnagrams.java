package com.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 242 Valid Anagrams 有效的字母异位词
 * @Author Monster
 * @Date 2020/8/8 14:28
 * @Version 1.0
 */
public class ValidAnagrams{
    /**
     * 1.先排序再对比
     * 执行时间 4ms 内存消耗 39.8M
     *
     * 2. 使用Arrays.equal()方法
     * @param s
     * @param t
     * @return
     */
    public boolean validAnagrams(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        char[] cht = t.toCharArray();
        Arrays.sort(cht);

        return Arrays.equals(chs, cht);
//        for(int i = 0; i < s.length();i++){
//            if(chs[i] != cht[i]){
//                return false;
//            }
//        }
//        return true;
    }

    /**
     * 1、通过两个Map对比
     * 时间 18ms  内存 40.3MB
     *
     * 2、修改为一个map对比
     * 时间 24ms 内存 41MB
     *
     * @param s
     * @param t
     * @return
     */
    public boolean validAnagrams2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        if(s.equals(t)){
            return true;
        }
        Map<Integer, Integer> recordS = new HashMap<>(s.length());
        for (int ch : s.toCharArray()) {
            if(recordS.containsKey(ch)){
                recordS.put(ch, recordS.get(ch) + 1);
            } else {
                recordS.put(ch, 1);
            }
        }
        int count = 0;
        for ( int ch : t.toCharArray()) {
            if(recordS.containsKey(ch) && recordS.get(ch) > 0){
                count++;
                recordS.put(ch, recordS.get(ch) - 1);
            }
        }
        if(count == t.length()){
            return true;
        }
        return false;

        /*
        Map<Integer, Integer> recordT = new HashMap<>(s.length());
        for (int ch : t.toCharArray()) {
            if(recordT.containsKey(ch)){
                recordT.put(ch, recordT.get(ch) + 1);
            } else {
                recordT.put(ch, 1);
            }
        }
        return recordT.equals(recordS);
        */


    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagrams().validAnagrams("aaagrams", "nagarams"));
    }
}
