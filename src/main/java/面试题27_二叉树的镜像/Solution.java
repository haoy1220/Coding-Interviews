package 面试题27_二叉树的镜像;

import 数据结构.TreeNode;

import java.util.Stack;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

/**
 * 思路
 * 使用递归
 * 遍历每个节点，交换它们的左右节点
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) return;

        Mirror(root.left);
        Mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }
}


/**
 * 思路
 * 使用循环
 */
class Solution2 {
    public void Mirror(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            swap(temp);

            if(temp.left != null){
                stack.push(temp.left);
            }

            if (temp.right != null){
                stack.push(temp.right);
            }

        }

    }

    //该方法接口应该是根节点，而不是两个子节点，
    //两个子节点会断开联系
    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}