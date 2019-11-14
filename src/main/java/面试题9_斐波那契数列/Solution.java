package 面试题9_斐波那契数列;

/*
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */

/*
 * 思路
 * 经典的基本解法，效率不高
 */
public class Solution {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}

/*
 * 思路
 * 为了避免重复计算，我们可以从小往大计算
 */
class Solution2 {
    public int Fibonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        int[] array = new int[n + 1];
//        int sum = 0;
//        array[0] = 0;
//        array[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            array[i] = array[i - 1] + array[i - 2];
//        }
//        return array[n];

        int result[] = {0, 1};
        if (n < 2) return result[n];

        int one = 0;
        int two = 1;
        int N = 0;
        for (int i = 2; i <= n; i++) {
            N = one + two;
            one = two;
            two = N;
        }
        return N;
    }
}

/*
 * 总结
 * 还有一些类似的题目可以转换为斐波那契数列题
 * 1.一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 2.我们可以用2 x 1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2 x 1的小矩形无重叠地覆盖一个2 x n的大矩形，总共有多少种方法？
 */