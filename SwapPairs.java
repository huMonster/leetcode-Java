package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 24 SwapPairs 两两交换链表中的节点
 * @Author Monster
 * @Date 2020/9/25 14:05
 * @Version 1.0
 */
public class SwapPairs {
    /**
     * pre   node1  node2   next
     *  0  ->  1  ->  2  ->  3 -> 4
     * 穿针引线：将pre指向node2， node2指向node1，node1指向next,即
     *
     *        ↗▔▔▔▔▔▔↘         将pre重新赋值
     * pre node1  node2   next        pre(old)----->pre
     *  0    1  <-  2    3 -> 4   ==>  0  ->  2  ->  1  ->  3 -> 4
     *  ↘________↗
     *
     * 时间复杂度 O(N) 空间复杂度 O(1)
     * 不建立虚拟节点也是可以的，但对算法效率影响不大且不利于理解
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode node1;
        ListNode node2;
        ListNode next;

        while (pre.next != null && pre.next.next != null) {
            node1 = pre.next;
            node2 = node1.next;
            next = node2.next;

            pre.next = node2;
            node2.next = node1;
            node1.next = next;

            pre = node1;
        }
        return dummyHead.next;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;

        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode node = ListNode.createNode(arr);
        ListNode.printNode(new SwapPairs().swapPairs2(node));
    }
}
