package com.algorithm.leetcode;

/**
 * @Description 206 ReverseList 反转链表
 * @Author Monster
 * @Date 2020/9/18 11:25
 * @Version 1.0
 */
public class ReverseList {
    /**
     * 思路：将next指针逆转,不改变原有位置。即：1->2->3->4->5->NULL 转换为 NULL<-1<-2<-3<-4<-5
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
