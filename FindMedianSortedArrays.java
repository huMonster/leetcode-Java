package com.algorithm.leetcode;


/**
 * @Description 4 FindMedianSortedArrays 寻找两个正序数组的中位数
 * @Author Monster
 * @Date 2020/8/31 10:50
 * @Version 1.0
 */
public class FindMedianSortedArrays {
    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 <= 0){
            int middle2 = len2 / 2;
            return len2 % 2 == 0 ? ((float)nums2[middle2 - 1] + (float)nums2[middle2])/2.00 : (float)nums2[middle2];
        }
        if(len2 <= 0){
            int middle1 = len1 / 2;
            return len1 % 2 == 0 ? ((float)nums1[middle1 - 1] + (float)nums1[middle1])/2.00 : (float)nums1[middle1];
        }
        int p = 0, p1 = 0, p2 = 0;
        int[] newNums = new int[len1 + len2];
        while (p1 < len1 && p2 < len2) newNums[p++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
        while (p1 < len1) newNums[p++] = nums1[p1++];
        while (p2 < len2) newNums[p++] = nums2[p2++];
        int num = newNums.length % 2;
        int middle = newNums.length / 2;
        return num == 0 ? ((float)newNums[middle - 1] + (float)newNums[middle])/2.00 : (float)newNums[middle];
    }

    /**
     * 二分查找 时间复杂度 O(log(m+n))
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        /**
         如果两个数组的中位数 mid1 < mid2, 则说明合并后的中位数位于 num1.right + num2之间
         否则合并后的中位数位于 nums2.right + nums1 之间 (right 是相对于 mid 而言的)
         getKth 函数负责找到两个数组合并(假设)后有序的数组中的第 k 个元素, k 从 1 开始计算
         **/
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        int m = nums1.length, n = nums2.length;
        // l: 合并后数组的左半部分的最后一个数 r: 合并后数组的右半部分的第一个数
        int l = (m+n+1) / 2;
        int r = (m+n+2) / 2;
        // 如果 m+n 是奇数 getKth 的返回值是相同的, 是偶数则是合并后数组的中间两个数
        if(l == r) return getKth(nums1, 0, nums2, 0, l);
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double getKth(int[] nums1, int st1, int[] nums2, int st2, int k) {
        // 边界情况, 如果 nums1数组已经穷尽了, 则只能返回 nums2 中的第 k 个元素
        if(st1 > nums1.length-1) return nums2[st2 + k - 1];
        if(st2 > nums2.length-1) return nums1[st1 + k - 1];
        // 边界情况, k = 1 则返回两个数组中最小的那个
        if(k == 1) return Math.min(nums1[st1], nums2[st2]);
        // 在 nums1 和 nums2 当前范围内找出 mid1 和 mid2 判断舍弃哪半部分
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if(st1 + k/2 - 1 < nums1.length) mid1 = nums1[st1 + k/2 - 1];
        if(st2 + k/2 - 1 < nums2.length) mid2 = nums2[st2 + k/2 - 1];
        // mid1 < mid2 在 nums1.right 和 nums2 之间搜索, 丢掉 k/2 个数.
        if(mid1 < mid2)
            return getKth(nums1, st1 + k/2, nums2, st2, k - k/2);
        else
            return getKth(nums1, st1, nums2, st2 + k/2, k - k/2);
    }

    public static void main(String[] args) {

        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays2(nums1, nums2));
    }
}
