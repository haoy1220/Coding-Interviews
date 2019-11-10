package 面试题5_从尾到头打印链表;

import org.junit.Test;
import 数据结构.ListNode;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/11/10 16:48
 */
public class Solution3Test {

    @Test
    public void printListFromTailToHead() {
        ListNode listNode = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next=listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        Solution3 solution = new Solution3();
        ArrayList<Integer> arrayList = solution.printListFromTailToHead(listNode);
    }
}