package com.algorithm.leetcode;

import java.util.*;

/**
 * @Description 149 MaxPoints 直线上最多的点数
 * @Author Monster
 * @Date 2020/9/3 15:53
 * @Version 1.0
 */
public class MaxPoints {
    /**
     * 思路：在一条直线上的点斜率是相同的（相同斜率的点却不一定在一条直线上）
     * 分别计算某一个点到所有点之间的斜率，将斜率作为Key,出现的次数作为Value，存入map中
     * 取出map中value的最大值与之前记录的最大值作比较，依次循环，得出结果。
     * 注意：1、如果斜率使用小数表示，会存在精度问题，所有使用分数表示，但必须找到公约数，进行约分。
     * 2、x轴相同或者y轴相同的两个点直接记录
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len < 3) {
            return len;
        }
        // key是两点的斜率， value是出现的次数
        HashMap<String, Integer> record = new HashMap<>();
        // 当前点重复的数
        int repeats;
        //保存经过当前点的直线中，最多的点
        int curMax;

        int result = 0;
        for (int i = 0; i < len; i++) {
            // 如果后面的点的数量少于最大直线点数，那么可以直接跳
            if (len - i <= result) {
                break;
            }
            record.clear();
            repeats = 0;
            curMax = 0;
            for (int j = i + 1; j < len; j++) {
                int x = (points[i][0] - points[j][0]);
                int y = (points[i][1] - points[j][1]);
                if (x == 0 && y == 0) {
                    repeats++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = x + "@" + y;
                record.put(key, record.getOrDefault(key, 0) + 1);
                curMax = Math.max(curMax, record.get(key));
            }
            // 1表示当前的点，repeats代表和当前的点重复的点的数量
            result = Math.max(result, curMax + repeats + 1);
        }
        return result;
    }

    /**
     * 求a和b的公约数
     *
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     * 优化: 1、添加限制条件，去除重复或者无意义的循环
     * 2、去掉HashMap
     *
     * @param points
     * @return
     */
    public int maxPoints2(int[][] points) {
        int len = points.length;
        if (len < 3) {
            return len;
        }
        // 最终的结果
        int reslut = 0;
        // 当前最大数
        int curMax;
        // 重复点数
        int repeats;

        for (int i = 0; i < len; i++) {
            // 限制条件
            if (len - i <= reslut) {
                break;
            }
            curMax = 1;
            repeats = 1;
            for (int j = i + 1; j < len; j++) {
                // 限制条件
                if (len - j + curMax <= reslut) {
                    break;
                }
                curMax++;
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    repeats++;
                } else {
                    for (int k = j + 1; k < len; k++) {
                        // 限制条件
                        if (len - k + curMax <= reslut) {
                            break;
                        }
                        int x1 = points[k][0] - points[j][0];
                        int y1 = points[k][1] - points[j][1];
                        // 将y/x = y1/x1 变为 x1 * y = y1 * x
                        if ((long) x1 * y == (long) x * y1) {
                            curMax++;
                        }
                    }
                }

                reslut = Math.max(reslut, curMax);
                curMax = repeats;
            }
        }
        return reslut;
    }


    public static void main(String[] args) {
//        int[][] point = {{1,1},{2,2},{3,3}};
        int[][] point = {{1,1},{1,1},{1,1}};
//        int[][] point = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(new MaxPoints().maxPoints2(point));
    }
}
