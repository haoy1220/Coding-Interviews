package 面试题22_链表中倒数第k个节点;

import 数据结构.ListNode;

/*
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        //链表为空,倒数不符合规范
        if (head == null) return null;
        if (k <=0 )return null;

        ListNode before = head;
        ListNode after = head;

        //before先走，并判断链表是否够长
        for (int i = 1; i < k; i++) {
            if (before.next != null) {
                before = before.next;
            }else {
                return null;
            }
        }


        //after开始跟着走了
        while (before.next != null) {
            before = before.next;
            after = after.next;
        }

        return after;

    }
}
