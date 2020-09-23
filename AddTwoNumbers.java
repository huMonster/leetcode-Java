package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 2 AddTwoNumbers 两数相加
 * @Author Monster
 * @Date 2020/8/20 15:45
 * @Modify 2020/9/23 11:20
 * @Version 2.0
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode record = new ListNode(0);
        ListNode cur = record;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int temp1 = l1 != null ? l1.val : 0;
            int temp2 = l2 != null ? l2.val : 0;
            int sum = temp1 + temp2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return record.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {5};
//        int[] arr2 = {5, 4, 6, 1};
        int[] arr2 = {5};
        ListNode l1 = ListNode.createNode(arr1);
        ListNode l2 = ListNode.createNode(arr2);
        ListNode.printNode(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
