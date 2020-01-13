package 面试题35_复杂链表的复制;

import 数据结构.RandomListNode;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        CloneNodes(pHead);
        ConnectRandomNode(pHead);
        return ReConnectNodes(pHead);
    }

    private RandomListNode ReConnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }

    private void ConnectRandomNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }

    //节点需要new，而不会凭空出现，赋值只是复制了地址
    private void CloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = null;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }
}
