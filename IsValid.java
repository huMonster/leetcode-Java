package com.algorithm.leetcode;

import java.util.Stack;

/**
 * @Description 20 IsValid 有效的括号
 * @Author Monster
 * @Date 2020/10/14 20:25
 * @Version 1.0
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '{' || chs[i] == '(' || chs[i] == '[') {
                stack.push(chs[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char match = 0;
                switch (chs[i]) {
                    case ')':
                        match = '(';
                        break;
                    case '}':
                        match = '{';
                        break;
                    case ']':
                        match = '[';
                        break;
                    default:
                        break;
                }
                if (match != stack.pop()) {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}";
        System.out.println(new IsValid().isValid2(s));
    }
}
