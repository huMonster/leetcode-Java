package com.algorithm.leetcode;

import com.test.utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 147 InsertionSortList 对链表进行插入排序
 * @Author Monster
 * @Date 2020/9/27 11:23
 * @Version 1.0
 */
public class InsertionSortList {
    /**
     * 遍历链表，逐一对比
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        // 设置虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 初始时head链表的第一个节点为前置节点pre
        ListNode pre = head;
        // 第二个节点为当前节点cur
        ListNode cur = pre.next;
        while(cur != null){
            if(cur.val < pre.val){
                // temp指向虚拟头节点，
                ListNode temp = dummy;
                // 找到比当前节点大的前一个节点
                for(;cur.val > temp.next.val;temp = temp.next);
                // 交换
                pre.next = cur.next;
                // cur.next不能直接指向pre，否则会丢失temp到pre之间的节点
                cur.next = temp.next;
                temp.next = cur;
                // 将前置节点的下一节点作为当前节点继续遍历
                cur = pre.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 将链表转换为List,排序后，又转换成链表
     * 
     * @param head
     * @return
     */
    public ListNode insertionSortList2(ListNode head) {
        List<Integer> record = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            record.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(record);
        ListNode resNode = head;
        for (int i = 0; i < record.size(); i++) {

            resNode.val = record.get(i);
            resNode = resNode.next;

        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        ListNode node = ListNode.createNode(arr);
        ListNode.printNode(new InsertionSortList().insertionSortList2(node));
    }
}
