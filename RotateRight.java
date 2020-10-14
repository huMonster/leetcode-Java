package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 61 RotateRight 旋转链表
 * @Author Monster
 * @Date 2020/9/30 15:54
 * @Version 1.0
 */
public class RotateRight {

    /**
     * 找到断链位置，将链断开，然后尾链接头链
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1;
        // 计算链表长度，并获取尾指针tail
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        // 去除重复循环
        k = k % len;
        if(k == 0 || k % len == 0) return head;
        // 计算断链位置
        k = len - k;
        ListNode crack = head;
        while(--k > 0){
            crack = crack.next;
        }
        // 记录头节点
        ListNode newHead = crack.next;
        // 断链，否则会成环
        crack.next = null;
        // 尾指针指向头节点
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        ListNode node = ListNode.createNode(arr);
        ListNode.printNode(new RotateRight().rotateRight(node, 2));
    }
}
