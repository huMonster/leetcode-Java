package com.algorithm.leetcode;

/**
 * @Description 657 JudgeCircle 机器人能否返回原点
 * @Author Monster
 * @Date 2020/8/28 9:40
 * @Version 1.0
 */
public class JudgeCircle {

    /**
     * 一般思路 效率低
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() <= 0){
            return true;
        }
        int x = 0, y = 0;
        char[] chars = moves.toCharArray();
        for (char ch:chars) {
            switch (ch){
                case 'U': ++y; break;
                case 'D': --y; break;
                case 'L': --x; break;
                case 'R': ++x; break;
            }
        }
        return x == 0 && y == 0;
    }

    /**
     * 优化思路
     * @param moves
     * @return
     */
    public boolean judgeCircle2(String moves) {
        if(moves == null || moves.length() <= 0){
            return true;
        }
        int[] record = new int[26];
        char[] chars = moves.toCharArray();
        for (char ch : chars) {
            record[ch - 'A']++;
        }
        return record['U' - 'A'] == record['D' - 'A'] && record['L' - 'A'] == record['R' - 'A'];
    }

    public static void main(String[] args) {
        String moves = "LL";
        System.out.println(new JudgeCircle().judgeCircle(moves));
    }
}
