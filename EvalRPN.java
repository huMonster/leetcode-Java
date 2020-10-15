package com.algorithm.leetcode;

import java.util.Stack;

/**
 * @Description 150 EvalRPN 逆波兰表达式求值
 * @Author Monster
 * @Date 2020/10/15 11:11
 * @Version 1.0
 */
public class EvalRPN {
    /**
     * 使用栈解决
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        // 将数组的第0位存入temp
        int temp = Integer.parseInt(tokens[0]);
        // 从数组的第1位开始判断
        for (int i = 1; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    temp += stack.pop();
                    break;
                case "-":
                    temp = stack.pop() - temp;
                    break;
                case "*":
                    temp *= stack.pop();
                    break;
                case "/":
                    temp = stack.pop() / temp;
                    break;
                default:
                    stack.push(temp);
                    // 不使用valueOf（自动拆装箱操作）, 使用parseInt
                    temp = Integer.parseInt(tokens[i]);
            }
        }
        return temp;
    }

    /**
     * 使用数组代替栈
     * @param tokens
     * @return
     */
    public int evalRPN2(String[] tokens) {
        // 节省空间
        int[] record = new int[tokens.length/2];
        // 数组下标
        int index = 0;
        int temp = Integer.parseInt(tokens[0]);
        // 从数组的第1位开始判断
        for (int i = 1; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    temp += record[--index];
                    break;
                case "-":
                    temp = record[--index] - temp;
                    break;
                case "*":
                    temp *= record[--index];
                    break;
                case "/":
                    temp = record[--index] / temp;
                    break;
                default:
                    record[index++] = temp;
                    // 不使用valueOf（自动拆装箱操作）, 使用parseInt
                    temp = Integer.parseInt(tokens[i]);
            }
        }
        return temp;
    }
    public static void main(String[] args) {
//        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(new EvalRPN().evalRPN2(tokens));
    }
}
