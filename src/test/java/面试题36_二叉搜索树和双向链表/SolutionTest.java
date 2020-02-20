package 面试题36_二叉搜索树和双向链表;

import org.junit.Test;
import 数据结构.TreeNode;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void convert() {
        TreeNode root = new TreeNode(10);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(8);
        TreeNode root5 = new TreeNode(14);
        TreeNode root6 = new TreeNode(12);
        TreeNode root7 = new TreeNode(16);

        root.left = root2;
        root2.left = root3;
        root2.right = root4;
        root.right = root5;
        root5.left = root6;
        root5.right = root7;

        Solution solution = new Solution();
        TreeNode ans = solution.Convert(root);
        System.out.println(ans);
    }
}