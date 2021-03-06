package 面试题32_从上到下打印二叉树;

import org.junit.Test;
import 数据结构.TreeNode;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void printFromTopToBottom() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode4.left = treeNode5;
        new Solution2().PrintFromTopToBottom(treeNode1);

    }
}