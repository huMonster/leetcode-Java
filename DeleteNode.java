package com.algorithm.leetcode;

import com.test.utils.ListNode;

/**
 * @Description 237 DeleteNode 删除链表中的节点
 * @Author Monster
 * @Date 2020/9/29 17:54
 * @Version 1.0
 */
public class DeleteNode {
    /**
     * 将下一个节点的值赋给当前节点，然后将当前节点的指针指向下下个节点，例如：
     * 已知删除节点 2
     * 链表 1 -> 2 -> 3 -> 4  将第三个节点的值赋给要删除的节点，得 1 -> 3 -> 3 -> 4
     * 之后将第二个节点的指针指向第四个节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
