package 面试题6_重建二叉树;

import 数据结构.TreeNode;

import java.util.Arrays;

/**
 * @author Hao
 * @date 2019/11/11 22:49
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
