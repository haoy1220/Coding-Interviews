package 面试题24_反转链表;

import 数据结构.ListNode;


/*
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;

        if (head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (cur != null) {
            cur.next = pre;
            pre = cur;
            if (next == null) {//这里容易出错，因为空节点的下一个节点继续赋值会出现空指针异常
                break;
            } else {
                cur = next;
                next = cur.next;
            }
        }
        return pre;
    }
}


/*
 * 思路
 * 用递归解
 */
class Solution2 {
    public ListNode ReverseList(ListNode head) {
        //终止条件
        if (head == null) return null;
        if (head.next == null) return head;

        //将下一节点开始递归
        ListNode newNode = ReverseList(head.next);

        //每层递归需要的操作
        head.next.next = head;//下一节点指向当前节点,反指，形成环
        head.next = null;//当前节点指向null，断开环
//        newNode.next = head;

        return newNode;
    }
}