package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 148 SortList 排序链表
 * @Author Monster
 * @Date 2020/9/29 11:32
 * @Version 1.0
 */
public class SortList {
    /**
     * 1、归并排序的思想
     * 2、快慢算法找链表中点
     * 3、断链和合链
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, slowPre = null;
        ListNode left, right;
        // 快慢算法找中点
        while (fast != null && fast.next != null) {
            // 中点的前一个点
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断链
        slowPre.next = null;
        left = sortList(head);
        right = sortList(slow);
        return merge(left, right);
    }

    /**
     * 合并两个有序链表
     *
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                cur = right;
                right = right.next;
            } else {
                cur.next = left;
                cur = left;
                left = left.next;
            }
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        ListNode node = ListNode.createNode(arr);
        ListNode.printNode(new SortList().sortList(node));
    }
}
