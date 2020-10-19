package com.algorithm.leetcode;

/**
 * @Description 844 BackspaceCompare 比较含退格的字符串
 * @Author Monster
 * @Date 2020/10/19 15:17
 * @Version 1.0
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        if(convert(S).equals(convert(T))){
            return true;
        }
        return false;
    }

    /**
     * 将带 “#”的字符串按要求转换为普通字符串
     *
     * @param str
     * @return
     */
    private String convert(String str){
        char[] chs = new char[str.length()];
        int index = 0;
        for (char ch : str.toCharArray()) {
            if(ch != '#'){
                chs[index++] = ch;
            } else if(index != 0){
                // 不用ch[--index] = ''
                index--;
            }
        }
        // 将字符组chs从0位转换成长度为index的字符串，即转换的长度区间为[0, index]
        return String.valueOf(chs, 0, index);
    }

    public static void main(String[] args) {
        String S = "a#c#", T = "b";
        System.out.println(new BackspaceCompare().backspaceCompare(S, T));
//        System.out.println(new BackspaceCompare().convert(T));
    }
}
