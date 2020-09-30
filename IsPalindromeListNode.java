package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 234 IsPalindrome 回文链表
 * @Author Monster
 * @Date 2020/9/30 11:27
 * @Version 1.0
 */
public class IsPalindromeListNode {
    /**
     * 1、利用快慢指针找到中点
     * 2、反转后半段链表
     * 3、与前半段链表进行值对比
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, pre = null;
        // 通过快指针找到中点（奇偶不影响）
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转slow及其后边的指针
        while(slow != null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 与前半段链表值对比
        while(pre != null){
            if(pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        ListNode node = ListNode.createNode(arr);
        System.out.println(new IsPalindromeListNode().isPalindrome(node));
    }
}
