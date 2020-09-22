package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 83 DeleteDuplicates 删除排序链表中的重复元素
 * @Author Monster
 * @Date 2020/9/22 10:38
 * @Version 1.0
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 声明一个当前节点
        ListNode cur = head;
        while (cur != null && cur.next != null){
            // 如果当前节点的值与下一个节点值相同，则当前节点的下一个指针指向下下个节点
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            } else {
                // 如果不一样，则当前节点指向下一个节点
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,4};
        ListNode head = ListNode.createNode(arr);
        ListNode.printNode(new DeleteDuplicates().deleteDuplicates(head));
    }
}
