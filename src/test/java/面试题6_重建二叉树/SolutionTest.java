package 面试题6_重建二叉树;

import org.junit.Test;
import 数据结构.TreeNode;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/11/11 23:11
 */
public class SolutionTest {

    @Test
    public void reConstructBinaryTree() {
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};
        Solution solution = new Solution();
        TreeNode treeNode = solution.reConstructBinaryTree(pre,in);
        
    }
}