package 面试题9_用两个栈实现队列;

import java.util.*;

/*
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

/*
 * 思路
 * 1.stack1用来压栈，stack2用来出栈；
 * 2.每次压栈前，将stack2的值压到stack1中，每次出栈前，将stack1的值压到stack2，保证了数据的顺序。
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}

/*
 * 思路
 * 1.第一个思路每次进队或出队都要颠倒栈的元素，极耗时间；
 * 2.问题出在元素顺序上，如果stack2不为空，stack还继续压入元素的话，那么顺序就会乱掉
 * 3.故而可以考虑只在stack2为空的时候再把stack1的元素压入stack2，节省了开销。
 */
class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

/*
 * 题目扩展描述
 * 两个队列实现栈
 */
class Solution3 {
    LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
    LinkedList<Integer> linkedList2 = new LinkedList<Integer>();

    public void push(int node) {
        linkedList1.add(node);
    }

    public int pop() {
        if (linkedList2.isEmpty()) {
            while (!linkedList1.isEmpty()){
                linkedList2.add(linkedList1.poll());
            }
        }
        return linkedList2.poll();
    }
}


/*
 * 总结
 * 注意数据的顺序，不难。
 */