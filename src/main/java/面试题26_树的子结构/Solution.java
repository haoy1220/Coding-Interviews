package 面试题26_树的子结构;

import 数据结构.TreeNode;

/*
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        boolean result = false;

        if (root1.val == root2.val) {
            result = DoesTree1HaveTree2(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return DoesTree1HaveTree2(root1.left, root2.left) &&
                DoesTree1HaveTree2(root1.right, root2.right);
    }
}


/*
 * 总结
 * 注意double值的比较，可以自己实现一个equals函数，差值在一定范围内表示相等，因为两个看起来一样的double值使用==往往结果不相等
 */