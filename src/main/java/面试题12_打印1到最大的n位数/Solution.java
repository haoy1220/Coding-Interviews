package 面试题12_打印1到最大的n位数;

/**
 * @author Hao
 * @date 2019/11/17 9:33
 */

/*
 * 题目描述
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的3位数即999.
 */

/*
 * 思路
 * 常规思路
 */
public class Solution {
    public void PrintLargest(int n) {
        int end = 1;
        while (n != 0) {
            end *= 10;
            n--;
        }
        for (int i = 1; i < end; i++) {
            System.out.print(i + "\t");
        }
    }
}

/*
 * 思路
 * 如果出现非常大的位数，那么使用常规解法就会发生溢出
 */
class Solution2 {
    public void PrintLargest(int n) {

    }
}