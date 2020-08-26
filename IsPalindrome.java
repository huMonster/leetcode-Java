package com.algorithm.leetcode;

/**
 * @Description 125 IsPalindrome 验证回文串
 * @Author Monster
 * @Date 2020/6/21 21:06
 * @Version 1.0
 */
public class IsPalindrome {
    public boolean isPalindrome(String s){
        // 字符串先转换为小写，再用正则表达式匹配小写字母和数字
        // 或者使用 (char)(ch | 0x20) 将某个字符字母转换为小写字母
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s){
        // 匹配是否为字符串：大小写+数字
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int i = 0, j = s.length() - 1;
        while(i < j){
            // 将大写字母转换为小写字母
            if((s.charAt(i++) | 0x20) != (s.charAt(j--) | 0x20)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new IsPalindrome().isPalindrome(s));
    }
}
