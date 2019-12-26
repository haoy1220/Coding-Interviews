package 面试题18_删除链表的结点;


import 数据结构.ListNode;

import java.util.*;

/*
 * 题目描述一：在O（1）时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O（1）时间内删除该节点。
 */
public class Solution {
    public void deleteNode(ListNode head, ListNode toBeDelete) {
        //判空
        if (head == null || toBeDelete == null) {
            return;
        }

        //要删除的不是尾节点
        if (toBeDelete.next != null) {
            ListNode next = toBeDelete.next;
            toBeDelete.val = next.val;
            toBeDelete.next = next.next;
        } else if (head == toBeDelete) {//只有一个节点
            head = null;//方法传递里无法把对象变为null
        } else {//删除尾节点
            ListNode node = head;
            while (node.next != toBeDelete) {
                node = node.next;
            }
            node.next = null;
        }
    }
}

/*
 * 题目描述二：删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

/*
 * 思路
 * 注意：是排好序的链表，且重复的结点不保留，即重复的都要删掉
 */
class Solution2 {
    public ListNode deleteDuplication(ListNode pHead) {

        //判空
        if (pHead == null)return null;

        //前置节点，用于连接后面不重复的节点
        ListNode preNode = null;

        //当前节点
        ListNode cur = pHead;

        while (cur != null){
            //下一节点
            ListNode next = cur.next;

            //判断是否重复，需要删除
            boolean delete = false;
            if (next != null && next.val == cur.val){
                delete = true;
            }

            if (delete){//重复删除
                int value = cur.val;

                //从当前节点开始，删到空或下一节点不为重复值为止
                ListNode toBeDelete = cur;
                while (toBeDelete != null && toBeDelete.val == value){
                    next = toBeDelete.next;
                    toBeDelete = next;
                }

                //如果前置节点为空，说明当前是头节点重复删除
                if (preNode == null){
                    pHead = next;//头节点从不重复处重新开始
                }else {
                    preNode.next = next;//前置节点不为空，则用前置节点的下一节点指向不重复的节点
                }
                cur = next;//从不重复节点重新开始判断
            }else {
                //没有重复的，则直接将当前节点作为前置节点，下一节点作为当前节点
                preNode = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }

}
