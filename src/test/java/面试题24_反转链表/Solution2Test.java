package 面试题24_反转链表;

import org.junit.Test;
import 数据结构.ListNode;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void reverseList() {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 0; i < 4; i++) {
            temp.next = new ListNode(i+2);
            temp = temp.next;
        }

        new Solution2().ReverseList(head);
    }
}