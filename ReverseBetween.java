package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 92 ReverseBetween 反转链表II
 * @Author Monster
 * @Date 2020/9/18 15:15
 * @Version 1.0
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        // 找到需要交换的节点（head）的前一位（pre）
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 得到head节点
        head = pre.next;
        for (int i = m; i < n; i++) {
            // 得到head的下一位
            ListNode next = head.next;
            // 交换
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.createNode(arr);
        ListNode.printNode(new ReverseBetween().reverseBetween(head, 2 ,5));
    }
}
