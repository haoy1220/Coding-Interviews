package 面试题7_重建二叉树;

import 数据结构.TreeNode;

import java.util.Arrays;

/**
 * @author Hao
 * @date 2019/11/11 22:49
 */

/*
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

/*
 * 思路
 * 1.前序遍历第一个为根节点，中序遍历根节点两边分别为左右子节点；
 * 2.由1可以看出，每次找到根节点后可以将数组划分为左右节点对应的前序遍历和中续遍历；
 * 3.之后都是重复操作，故可以考虑使用递归解决问题。
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = Construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    public static TreeNode Construct(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end) {
        if (pre_start > pre_end || in_start > in_end) return null;
        TreeNode root = new TreeNode(pre[pre_start]);
        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == pre[pre_start]) {
                root.left = Construct(pre, pre_start + 1, pre_start + i - in_start, in, in_start, i - 1);
//                root.left = Construct(pre, pre_start + 1, i, in, in_start, i - 1);
//                root.right = Construct(pre, i + 1, pre_end, in, i + 1, in_end);
                root.right = Construct(pre, i - pre_start + in_start + 1, pre_end, in, i + 1, in_end);
                break;
            }
        }

        return root;
    }
}

class Solution2 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i, in.length));
                break;
            }
        }
        return root;
    }
}

/*
 * 总结
 * 1.考虑无左节点或右节点的情况；
 * 2.对于大问题可以化成许多相同小问题的题目，可以使用递归处理。
 */