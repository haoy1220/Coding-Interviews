package 面试题30_包含min函数的栈;

import java.util.Stack;

/*
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

/*
 * 思路
 * 因为要在O（1）时间内，所以遍历之类的方法行不通
 * 我们可以通过使用额外空间来实现，如果是使用一个值来存储，那么当弹出最小元素后，当前栈的最小元素就无法得到更新，或者需要更大的代价来更新
 * 因此可以使用一个辅助栈，在添加数据的时候，辅助栈每次都压当前栈的最小值入栈，当前栈弹出元素时，辅助栈也弹出，就保证了一致性
 */
public class Solution {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来存放每一步的最小值

    public void push(int node) {

        //判断辅助栈是否为空
        int min = 0;
        if (stack2.isEmpty()){
            min = node;
        }else {
            min = node < stack2.peek() ? node : stack2.peek();
        }
        stack1.push(node);
        stack2.push(min);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
