package 面试题32_从上到下打印二叉树;


import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        if (root == null) return arrayList;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            arrayList.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return arrayList;
    }
}

/**
 * 题目描述
 * 在第一种情况下，分层打印
 */
class Solution2 {
    public void PrintFromTopToBottom(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int toBePrint = 1;
        int nextPoint = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
                nextPoint++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextPoint++;
            }
            toBePrint--;
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextPoint;
                nextPoint = 0;
            }
        }

    }

}

/**
 * 题目描述
 * 在第一种基础上，z字形打印
 */
class Solution3 {
    public void PrintFromTopToBottom(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int toBePrint = 1;
        int nextPoint = 0;
        boolean turn = true;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (turn) {
                if (temp.right != null) {
                    queue.add(temp.right);
                    nextPoint++;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                    nextPoint++;
                }
            } else {
                if (temp.left != null) {
                    queue.add(temp.left);
                    nextPoint++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    nextPoint++;
                }
            }
            toBePrint--;
            if (toBePrint == 0) {
                System.out.println();
                turn = !turn;
                toBePrint = nextPoint;
                nextPoint = 0;
            }
        }

    }

}

/**
 * 总结
 * 顺序类的题多考虑一下栈和队列等进出有序的数据结构
 * 队列尤为适合广度优先的算法
 */