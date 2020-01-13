package 面试题34_二叉树中和为某一值的路径;


import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //判空，其中target值为0时，root可以为任意，返回空的结果就好
        if (target == 0) return arrayLists;
        if (root == null) return null;

        //记录当前遍历的结点
        Stack<TreeNode> stack = new Stack<TreeNode>();

        //记录当前累积值
        int currentSum = 0;

        //开始查找
        findPath(root, target, stack, currentSum);

        return arrayLists;
    }

    private void findPath(TreeNode root, int target, Stack<TreeNode> stack, int currentSum) {
        //记录累计值以及当前结点
        currentSum += root.val;
        stack.push(root);

        if (root.left == null && root.right == null && target == currentSum) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (TreeNode node :
                    stack) {
                arrayList.add(node.val);
            }
            arrayLists.add(arrayList);
        }

        if (root.left != null) {
            findPath(root.left, target, stack, currentSum);
        }

        if (root.right != null) {
            findPath(root.right, target, stack, currentSum);
        }

        stack.pop();
    }
}


class Solution2 {
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return arrayLists;
        arrayList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            arrayLists.add(new ArrayList<Integer>(arrayList));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        arrayList.remove(arrayList.size() - 1);
        return arrayLists;
    }
}