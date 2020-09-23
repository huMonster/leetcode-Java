package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 328 OddEvenList 奇偶链表
 * @Author Monster
 * @Date 2020/9/23 9:27
 * @Version 1.0
 */
public class OddEvenList {

    /**
     * 一个链表存放奇节点，一个链表存放偶节点，然后奇链表的尾节点连接偶链表的头节点即可
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        // p是奇链表
        ListNode p = new ListNode(0);
        // o是偶链表
        ListNode o = new ListNode(0);

        ListNode pNode = p;
        ListNode oNode = o;
        // 判断当前节点是奇结点还是偶节点
        int count = 1;

        while(head != null){
            if(count == 1){
                pNode.next = head;
                head = head.next;
                pNode = pNode.next;
                pNode.next = null;
                count = 0;
            } else {
                oNode.next = head;
                head = head.next;
                oNode = oNode.next;
                oNode.next = null;
                count = 1;
            }
        }
        pNode.next = o.next;
        return p.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = ListNode.createNode(arr);
        ListNode.printNode(new OddEvenList().oddEvenList(head));
    }
}
