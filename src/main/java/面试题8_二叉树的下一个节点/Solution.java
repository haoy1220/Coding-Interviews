package 面试题8_二叉树的下一个节点;

import 数据结构.TreeLinkNode;

/**
 * @author Hao
 * @date 2019/12/5 21:10
 */

/*
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/*
 * 思路
 * 中序排序不考虑有无左子结点
 * 先考虑有右子节点：下一个结点就是右子节点的最左子节点
 * 再考虑有父节点：
 *      1、是父节点的右子节点：说明已经是一个尽头了，下一个节点要遍历它的父节点，
 *                              直到被遍历的节点是其父节点的左子结点，那么这个父节点就是了
 *      2、是父节点的左子节点：下一个结点就是父节点
 */
public class Solution {
    /*
     * @method_name:GetNext
     * @param:  pNode, 二叉树中的一个结点
     * @return:数据结构.TreeLinkNode
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        TreeLinkNode pNext = null;
        //有右结点
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            //右结点存在左节点则下一个结点需要遍历到最左的结点，不然下一个结点就是右结点
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;

            //有父节点
        } else if (pNode.next != null) {
            TreeLinkNode pFather = pNode.next;
            TreeLinkNode pCurrent = pNode;
            //父节点是父父结点的右结点，则继续向上遍历，直到null，或者是父节点的左子节点结束
            while (pFather != null && pFather.right == pCurrent) {
                pCurrent = pFather;
                pFather = pFather.next;
            }
            pNext = pFather;
        }
        return pNext;
    }
}
