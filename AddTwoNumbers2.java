package com.algorithm.leetcode;

import com.test.utils.ListNode;

import java.util.Stack;

/**
 * @Description 445 addTwoNumbers2 两数相加 II
 * @Author Monster
 * @Date 2020/9/23 14:01
 * @Version 1.0
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 利用栈先进后出的特点，将链表放入栈中
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // 进位
        int carry = 0;
        ListNode record = new ListNode(0);
        ListNode cur = record;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int temp1 = stack1.isEmpty() ? 0 : stack1.pop();
            int temp2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = temp1 + temp2 + carry;
            // 只要结果为1.x, 就会向下取，即为1
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = cur.next;
            cur.next = node;
        }
        return record.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode node1 = ListNode.createNode(arr1);
        ListNode node2 = ListNode.createNode(arr2);
        ListNode.printNode(new AddTwoNumbers2().addTwoNumbers(node1, node2));
    }
}
