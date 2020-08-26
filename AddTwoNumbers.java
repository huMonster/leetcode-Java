package com.test.leetcode;

/**
 * @Description 2 AddTwoNumbers 两数相加
 * @Author Monster
 * @Date 2020/8/20 15:45
 * @Version 1.0
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/**
 * 泛型线性表单链
 *
 * @param <E>
 */
class ListNode2<E>{
    E val;
    ListNode2<E> next;
    ListNode2(E val){
        this.val = val;
    }
}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        // 进位
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int temp1 = l1 != null ? l1.val : 0;
            int temp2 = l2 != null ? l2.val : 0;
            int sum = temp1 + temp2 + carry;
            // 当sum大于10，默认向下取整，carry = 1
            carry = sum / 10;

            ListNode record = new ListNode(sum % 10);

            cursor.next = record;
            cursor = record;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(5);
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(l1, l2);
        ListNode head = listNode;
        while(head != null){
            System.out.println(head.val + "  ");
            head = head.next;
        }
    }
}
