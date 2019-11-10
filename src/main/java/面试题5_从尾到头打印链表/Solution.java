package 面试题5_从尾到头打印链表;

import 数据结构.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author Hao
 * @date 2019/11/10 10:36
 */

/*
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

/*
 * 思路
 * 1.考虑是否可以改变原链表的结构；
 * 2.如果不可以改变结构，从尾到头，是典型的“后进先出”例子，可以用栈来解决。
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp = listNode;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}

/*
 * 思路
 * 1.栈的思想其实跟递归（本质上就是栈结构）是一样的，这道题也可以用递归来解。
 */
class Solution2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Find(listNode, arrayList);
        return arrayList;
    }

    private void Find(ListNode listNode, ArrayList<Integer> arrayList) {
        if (listNode == null) {
            return;
        }
        Find(listNode.next, arrayList);
        arrayList.add(listNode.val);
    }
}

/*
 * 思路
 * 如果可以改变原链表，只要将原链表反转，之后从头到尾输出即可。
 */
class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        listNode = reverseListNode(listNode);
        while (listNode != null) {
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        return arrayList;
    }

    private ListNode reverseListNode(ListNode listNode) {
        ListNode prev = null;
        while (listNode != null) {
            ListNode nextTemp = listNode.next;
            listNode.next = prev;
            prev = listNode;
            listNode = nextTemp;
        }
        return prev;
    }
}
