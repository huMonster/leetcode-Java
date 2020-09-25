package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 21 MergeTwoLists 合并两个有序链表
 * @Author Monster
 * @Date 2020/9/24 17:56
 * @Version 1.0
 */
public class MergeTwoLists {
    /**
     * 迭代
     * 
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 设置虚拟头节点
        ListNode dummy = new ListNode(0);
        // 引入cur指向虚拟头节点
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 处理两个链表比较后l1或l2剩余的节点
        cur.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        } else if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode l1 = ListNode.createNode(arr1);
        ListNode l2 = ListNode.createNode(arr2);
        ListNode.printNode(new MergeTwoLists().mergeTwoLists(l1, l2));
    }
}
