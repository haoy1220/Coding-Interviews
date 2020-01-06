package 面试题33_二叉树搜索树的后序遍历序列;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) return true;

        int i = end;
        while (i > start && sequence[i - 1] > sequence[end]){
            i--;
        }

        for (int j = start; j < i - 1; j++) {
            if (sequence[j] > sequence[end]) {
                return false;
            }
        }

        return (verifySequenceOfBST(sequence, start, i - 1) && verifySequenceOfBST(sequence, i, end - 1));
    }
}
