package 面试题23_链表中环的入口节点;

import 数据结构.ListNode;

import java.util.List;

/*
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

/*
 * 思路
 * 1、先用快慢指针判断是否存在环
 * 2、使用两种方法判断环的入口：
 *      方法一：需要知道环内的相遇点，和头结点
 *      方法二：需要知道环的长度，头结点
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        //没环就返回null
        if (meetingNode == null) return null;

        //统计环的节点数（环长）
        int nodeCount = nodeCount(meetingNode);

        ListNode node1 = entryNode2(pHead, nodeCount);

        return node1;
    }

    //判断入口方法二（详细证明看总结）
    private ListNode entryNode2(ListNode pHead, int nodeCount) {

        ListNode node1 = pHead;
        for (int i = 0; i < nodeCount; i++) {
            node1 = node1.next;
        }

        ListNode node2 = pHead;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    //判断入口方法一
    private ListNode entryNode1(ListNode pHead, ListNode meetingNode) {
        ListNode node1 = pHead;
        ListNode node2 = meetingNode;

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    //快慢指针判断是否存在环
    private ListNode meetingNode(ListNode pHead) {
        //判空
        if (pHead == null) return null;

        //慢指针
        ListNode slow = pHead.next;
        if (slow == null) return null;

        //快指针
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }

            slow = slow.next;

            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

        }

        return null;

    }

    //判断环的长度
    private int nodeCount(ListNode loopNode) {
        int count = 1;
        ListNode temp = loopNode.next;
        while (temp != loopNode) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}

/*
 * 总结
 * 环的入口证明一：
 *      链表头节点到入口长x，从入口到相遇长y，剩余环长z，环长L；
 *      slow的路程：S = x + y;2S = x + x + y + y
 *      fast的路程：2S = x + y + nL(n是比slow多走的圈数)
 *      所以nL = x + y,又因为y + z = L
 *      x = (n - 1)L + z,意味着一个节点从头结点出发到入口，相当于另一个节点在环内相遇点出发走（n-1）圈和z后会在入口相遇
 * 环的入口证明二：
 *      头结点到入口为x，环长为L，链表长度len = x + L
 *      先走一个环长L，那么剩余到入口的路程z有len = z + L
 *      明显x = z
 */