package com.algorithm.leetcode;

import java.util.*;

/**
 * @Description 350 Intersect II 两个数组的交集 II
 * @Author Monster
 * @Date 2020/8/2 12:32
 * @Version 1.0
 */
public class Intersect {
    /**
     * 无序数组
     * 利用map集合将元素出现得次数以Key-value记录
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2){
        if(nums1.length <= 0 || nums2.length <= 0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> record = new HashMap<>(nums2.length);

        for (int i = 0; i < nums2.length; i++) {
            record.put(nums2[i], record.getOrDefault(nums2[i], 0) + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            if(record.containsKey(nums1[i]) && record.get(nums1[i]) > 0){
                list.add(nums1[i]);
                record.put(nums1[i], record.get(nums1[i]) - 1);
            }
        }
        int[] result = new int[list.size()];
        int next = 0;
        for (int num : list) {
            result[next++] = num;
        }
        return result;
    }

    /**
     * 无序数组
     * 利用list是否包含判断
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> record = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }
        List<Integer> target = new ArrayList<>();
        Iterator<Integer> iterator = record.iterator();
        int i = 0;
        while(iterator.hasNext() && i < nums2.length){
            if(iterator.next() == nums2[i++]){
                target.add(nums2[i]);
                iterator.remove();
            }
        }
        int[] result = new int[target.size()];
        int next = 0;
        for (int num : target) {
            result[next++] = num;
        }
        return result;
    }
    /**
     * 有序数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect3(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> record = new ArrayList<>();
        int i= 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                record.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[record.size()];
        int next = 0;
        for (int num : record) {
            result[next++] = num;
        }
        return result;
    }
    public static void main(String[] args) {
//        int [] nums1 = {1,2,2,1}, nums2 = {2,2};
        int [] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(new Intersect().intersect(nums1, nums2)));
    }
}
