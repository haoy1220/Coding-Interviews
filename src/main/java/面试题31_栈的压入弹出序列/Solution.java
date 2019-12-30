package 面试题31_栈的压入弹出序列;

import java.util.Stack;

/*
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<Integer>();
        int push = 0;
        int pop = 0;

        while (push <= pushA.length || pop < popA.length) {//因为压入最后一个数后还要比较一次，所以要等于
            if (!stack.isEmpty() && popA[pop] == stack.peek()) {//如果和栈顶的元素相同就弹出
                stack.pop();
                pop++;
            } else if (push == pushA.length) {//压入的最后一个数比较完就要退出了，不然会越界
                break;
            } else {
                stack.push(pushA[push++]);
            }

        }

        //全弹出来了说明可以
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
