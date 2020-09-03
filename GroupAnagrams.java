package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 49 GroupAnagrams 字母异位词分组
 * @Author Monster
 * @Date 2020/9/2 15:48
 * @Version 1.0
 */
public class GroupAnagrams {
    /**
     * 利用质数乘积来保证异位字母的乘积是相同的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 质数数组，nums[a - 'a']对应质数2，nums[b - 'a']对应质数3，依次类推。
        int[] nums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        // 利用map记录查找结果，返回的结果集是ArrayList<String>
        HashMap<Double, ArrayList<String>> map = new HashMap<>();
        // 用double记录乘积
        double count;
        char[] chs;
        for (int i = 0; i < strs.length; i++) {
            count = 1;
            chs = strs[i].toCharArray();
            for (int j = 0; j < strs[i].length(); j++) {
                count = nums[chs[j] - 'a'] * count;
            }
            if(!map.containsKey(count)){
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 将字母排序后对比
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, ArrayList<String>> record = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!record.containsKey(key)){
                record.put(key, new ArrayList<>());
            }
            record.get(key).add(str);
        }
        return new ArrayList<>(record.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}
