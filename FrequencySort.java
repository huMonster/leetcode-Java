package com.algorithm.leetcode;

import java.util.*;

/**
 * @Description 451 FrequencySort 根据字符出现的频率排序
 * @Author Monster
 * @Date 2020/8/16 12:34
 * @Version 1.0
 */
public class FrequencySort {
    public String frequencySort(String s){
        char[] chars = s.toCharArray();
        Map<Character, Integer> record = new HashMap(16);
        for (char ch : chars ) {
            record.put(ch, record.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> maxHead = new PriorityQueue<>(
                // o2 - o1会产生溢出，导致结构不正确
                // (o1, o2) -> record.get(o2) - record.get(o1)
                (o1, o2) -> record.get(o2).compareTo(record.get(o1))
        );
        maxHead.addAll(record.keySet());
        StringBuffer stringBuffer = new StringBuffer();
        while (!maxHead.isEmpty()){
            char key = maxHead.poll();
            int value = record.get(key);
            for (int i = 0; i < value; i++) {
                stringBuffer.append(key);
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "abbccccd";
        System.out.println(new FrequencySort().frequencySort(s));
    }
}
