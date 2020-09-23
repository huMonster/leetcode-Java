package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 203 RemoveElements 移除链表元素
 * @Author Monster
 * @Date 2020/9/23 16:21
 * @Version 1.0
 */
public class RemoveElements {
    /**
     * 使用当前节点的下一个节点的值与val比较，即cur.next ? val
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 创建一个虚拟节点root
        ListNode root = new ListNode(0);
        // 让root的下一个节点指向head链表
        root.next = head;
        // 让当前节点从虚拟节点root开始，对比下一个节点与val的值即可
        ListNode cur = root;
        while(cur.next != null){
            // 如果cur.next的值等于val，则cur的next指针直接指向cur的下下个节点
            if(cur.next.val == val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return root.next;
    }

    /**
     * 其实跟第一种方法一样，只是与val比较值的参照节点不同，
     * 方法一是当前节点的下一个节点值与val比较
     * 该方法时当前值与val比较
     * 第一种方法更简洁
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        ListNode cur = pre.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return root.next;
    }

    /**
     * 不设置虚拟节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        while( head != null && head.val == val){
            head = head.next;
        }
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,6,3,4,5,6};
        int[] arr = {};
        ListNode node = ListNode.createNode(arr);
        ListNode.printNode(new RemoveElements().removeElements(node, 6));
    }
}
