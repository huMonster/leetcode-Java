package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 86 Partition 分隔链表
 * @Author Monster
 * @Date 2020/9/22 11:03
 * @Version 1.0
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        // 建立两个虚拟节点
        ListNode max = new ListNode(0);
        ListNode min = new ListNode(0);
        // 一个存放比x大的节点，一个存放比x小的节点
        ListNode maxNode = max;
        ListNode minNode = min;

        while (head != null){
            if(head.val >= x){
                maxNode.next = head;
                head = head.next;
                maxNode = maxNode.next;
            } else {
                minNode.next = head;
                head = head.next;
                minNode = minNode.next;
            }
        }
        // 置空，防止成环
        maxNode.next = null;
        // 头尾相连
        minNode.next = max.next;

        return min.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5,4};
        ListNode head = ListNode.createNode(arr);
        ListNode.printNode(new Partition().partition(head, 4));
    }
}
