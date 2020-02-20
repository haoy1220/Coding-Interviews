package 面试题37_序列化二叉树;

import org.junit.Test;
import 数据结构.TreeNode;

import static org.junit.Assert.*;

public class SolutionTest {


    @Test
    public void serialize() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Solution solution = new Solution();
        String string = solution.Serialize(node1);
        System.out.println(string);

    }

    @Test
    public void deserialize() {

        String string = "3!4!6!#!#!7!#!#!5!#!#!";
        Solution solutin = new Solution();
        solutin.Deserialize(string);


    }
}