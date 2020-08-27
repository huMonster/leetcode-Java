package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 17 LetterCombinations 电话号码的字母组合
 * @Author Monster
 * @Date 2020/8/26 10:10
 * @Version 1.0
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        //这里也可以用map，用数组可以更节省点内存
        String[] mapNum = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = mapNum[digits.charAt(i) - '0'];
            int size = res.size();
            //计算出长度后，将每个元素依次拿出来
            for (int j = 0; j < size; j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }
        return res;
    }


    List<String> list = new ArrayList<>();
    String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuffer path = new StringBuffer();

    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        help(digits, 0);
        return list;
    }

    private void help(String str, int len) {
        if (len >= str.length()) {
            list.add(path.toString());
            return;
        }
        String ss = strs[str.charAt(len) - '2'];
        for (int i = 0; i < ss.length(); i++) {
            path.append(ss.charAt(i));
            help(str, len + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "2345";
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }
}
