package 面试题25_合并两个排序的链表;


import 数据结构.ListNode;

/*
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {

        //判空
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //比较合并
        ListNode mergeNode = null;
        if (list1.val < list2.val) {
            mergeNode = list1;
            mergeNode.next = Merge(list1.next, list2);//递归处理
        } else {
            mergeNode = list2;
            mergeNode.next = Merge(list1, list2.next);//递归处理
        }

        return mergeNode;
    }
}
