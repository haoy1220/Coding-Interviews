package 面试题36_二叉搜索树和双向链表;

import 数据结构.TreeNode;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        //终止条件：
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }

        TreeNode left = Convert(pRootOfTree.left);
        TreeNode last = left;

        while (last != null && last.right != null) {
            last = last.right;
        }

        if (left != null) {
            pRootOfTree.left = last;
            last.right = pRootOfTree;
        }

        TreeNode right = Convert(pRootOfTree.right);

        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
}
  