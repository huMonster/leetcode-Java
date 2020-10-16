package com.algorithm.leetcode;

import java.util.Stack;

/**
 * @Description 71 SimplifyPath 简化路径
 * @Author Monster
 * @Date 2020/10/15 15:58
 * @Version 1.0
 */
public class SimplifyPath {

    /**
     * 使用栈
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String ch : path.split("/")) {
            // 将"", ".",".."以外的字符串放入栈中
            // 如果遇到..，则将栈中pop出，即代表返回上一目录
            if (!ch.isEmpty() && !ch.equals(".") && !ch.equals("..")) {
                stack.push(ch);
            } else if (ch.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        // 单线程下，使用StringBuilder比StringBuffer效率更高
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            // 0表示插入当前第一位
            // sb.insert(0,"/" + stack.pop()) 这种写法影响效率
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.length() == 0 ? "/" : sb + "";
    }

    /**
     * 将栈改为数组，效率更高
     *
     * @param path
     * @return
     */
    public String simplifyPath2(String path) {
        String[] strs = new String[path.length()];
        // 设置一个数组下标
        int index = 0;
        for (String ch : path.split("/")) {
            // 将"", ".",".."以外的字符串放入栈中
            // 如果遇到..，则将栈中pop出，即代表返回上一目录
            if (!ch.isEmpty() && !ch.equals(".") && !ch.equals("..")) {
                strs[index++] = ch;
            } else if (ch.equals("..") && index > 0) {
                --index;
            }
        }
        // 单线程下，使用StringBuilder比StringBuffer效率更高
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < index; i++) {
            sb.append("/");
            sb.append(strs[i]);
        }

        return index == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
//        String path = "/home/";
//        String path = "/../";
        String path = "/home//foo/";
//        String path = "/a/../../b/../c//.//";
//        String path = "/a//b////c/d//././/..";
        System.out.println(new SimplifyPath().simplifyPath2(path));
    }
}
