package 面试题18_删除链表的结点;

import org.junit.Test;
import 数据结构.ListNode;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void deleteNode() {
        ListNode head = new ListNode(9);
//        ListNode temp = head;
//        for (int i = 1; i < 5; i++) {
//            ListNode listNode = new ListNode(i);
//            temp.next = listNode;
//            temp = listNode;
//        }
//        ListNode toBeDelete = head.next.next.next;

        new Solution().deleteNode(head,head);
        while (head != null){
            System.out.println(head.val + " ");
            head = head.next;
        }

    }
}

