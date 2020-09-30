package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 19 RemoveNthFromEnd 删除链表的倒数第N个节点
 * @Author Monster
 * @Date 2020/9/30 9:30
 * @Version 1.0
 */
public class RemoveNthFromEnd {
    /**
     * 思路：先遍历一遍链表计算长度len，len - n + 1得值就是正数的要删除的节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        // 建立虚拟头节点
        ListNode dummy = new ListNode(0);
        // 并指向head
        dummy.next = head;
        // 释放内存
        head = null;

        int len = 0;
        // 当前指针指向头节点
        ListNode cur = dummy.next;
        // 计算链表长度
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        cur = dummy.next;
        // 要删除的节点的前一个节点
        ListNode pre = dummy;
        for (int i = 0; i < len - n; i++) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        ListNode retNode = dummy.next;
        // 释放dummy内存
        dummy = null;
        return retNode;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = null;

        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        ListNode retNode = dummy.next;
        dummy = null;
        return retNode;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode node = ListNode.createNode(arr);
        ListNode.printNode(new RemoveNthFromEnd().removeNthFromEnd2(node, 2));
    }
}
