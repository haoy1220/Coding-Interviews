package 面试题22_链表中倒数第k个节点;

import org.junit.Test;
import 数据结构.ListNode;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findKthToTail() {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 0; i < 4; i++) {
            temp.next = new ListNode(i+2);
            temp = temp.next;
        }

        head = new Solution().FindKthToTail(head,1);
    }
}