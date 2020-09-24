package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 82 DeleteDuplicates2 删除排序链表中的重复元素 II
 * @Author Monster
 * @Date 2020/9/24 16:30
 * @Version 1.0
 */
public class DeleteDuplicates2 {
    /**
     * 创建虚拟节点，然后指向head，虚拟节点作为当前节点（cur）对比当前节点的下一个节点(cur.next)和下下个节点(cur.next.next)的值，
     * 如果相同，则让cur.next直接指向cur.next.next，即 0->1->1->2变为0->1->2
     * 使用isDel标记cur.next是否需要删除
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 创建虚拟节点
        ListNode dummy = new ListNode(0);
        // 让虚拟节点的下一个节点指向head
        dummy.next = head;
        ListNode cur = dummy;
        boolean isDel = false;
        if (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                isDel = true;
                cur.next = cur.next.next;
            } else {
                if (isDel) {
                    cur.next = cur.next.next;
                    isDel = false;
                } else {
                    cur = cur.next;
                }
            }
        }
        // 如果遇到[1,1,1,1]这种的，删除到最后一个节点会因为不满足循环直接跳出，从而使得cur.next保存下来了，
        // 因此需要在此处将cur.next置空
        if (isDel) {
            cur.next = null;
        }
        return dummy.next;
    }

    /**
     * 不使用虚拟节点
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        if (head.val == cur.val) {
            // 需要移动next直到出现与当前head.value不相等的情况（含null）
            while (cur != null && head.val == cur.val) cur = cur.next;
            // 此时的head已经不能要了(重复的节点)
            head = deleteDuplicates2(cur);
        } else {
            // 递归返回的节点就作为head的子节点
            head.next = deleteDuplicates2(cur);
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3};
        ListNode node = ListNode.createNode(arr);
        ListNode.printNode(new DeleteDuplicates2().deleteDuplicates2(node));
    }
}
