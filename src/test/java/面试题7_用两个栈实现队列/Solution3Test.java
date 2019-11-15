package 面试题7_用两个栈实现队列;

import static org.junit.Assert.*;

public class Solution3Test {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.push(1);
        solution3.push(2);
        solution3.push(3);
        solution3.push(4);
        System.out.println(solution3.pop());
        System.out.println(solution3.pop());
        System.out.println(solution3.pop());
        solution3.push(5);
        solution3.push(6);
        solution3.push(7);
        System.out.println(solution3.pop());
        System.out.println(solution3.pop());
        System.out.println(solution3.pop());
        System.out.println(solution3.pop());
        solution3.push(8);
        System.out.println(solution3.pop());
    }
}