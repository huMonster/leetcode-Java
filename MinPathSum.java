package com.algorithm.leetcode;

/**
 * @Description 64 MinPathSum 最小路径和
 * @Author Monster
 * @Date 2021/5/8 14:35
 * @Version 1.0
 */
public class MinPathSum {
    public static int dp(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];

            }
        }
        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(dp(grid));
    }
}
