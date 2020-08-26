package com.algorithm.leetcode;

/**
 * @Description 3 LengthOfLongestSubstring 最长无重复子串
 * @Author Monster
 * @Date 2020/6/27 11:57
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

    private int lengthOfLongestSubstring(String s) {
        // 初始化时,r = -1, 则[l,r]区间无效
        int l = 0, r = -1;
        int[] freq = new int[256];
        int len = 0;
        char[] ch = s.toCharArray();
        while(l < s.length()){
            if(r + 1 < s.length() && freq[ch[r+1]] == 0){
                freq[ch[++r]]++;
            } else {
                freq[ch[l++]]--;
            }

            len = len > r - l + 1 ? len : r - l + 1;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }


}
