package 面试题14_剪绳子;

/**
 * @author Hao
 * @date 2019/12/8 8:55
 */

/*
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */

/*
 * 思路
 * 先采用O(n^2)时间和O(n)空间的动态规划解法
 */
public class Solution {
    public int cutRope(int target) {
        //先列出长度小于等于3部分的可能
        if (target < 2) return 0;//无法切分，为0
        if (target == 2) return 1;//切为两个1，为1
        if (target == 3) return 2;//切为2*1或1*1*1，最优为2

        //用数组存储大于3部分的小问题最优解
        int[] products = new int[target + 1];
        //小于3的长度对于大于3部分的绳子来说，最优解是它本身，因为大于3的部分可以分为3*（i-3）
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        //从长度为4的开始
        for (int i = 4; i <= target; i++) {
            max = 0;
            //从切为1开始，计算当前的最优值，因为类似2*3和3*2是一样的，所以算一半就好了
            //这里可能会有疑问，这不是才分成两段吗？怎么就是最优的了
            //  要记住，分成的两段，存储的都是这两段长度能存储的最优值，而不是它们长度本身
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[target];
        return max;
    }
}


/*
 * 思路
 * O（1）时间和空间的贪婪算法
 */
class Solution2 {
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;

        //尽可能切分为3
        int timesOf3 = target / 3;

        //最后一段为4时，切为2*2比较好
        if (target - timesOf3 * 3 == 1)
            timesOf3 -= 1;


        int timesOf2 = (target - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
}


/*
 * 总结
 * 动态规划的特点：
 *      1、求最优解（一般是最大值或最小值）的问题
 *      2、大问题可分解为小问题，且整体问题的最优解是依赖各个小问题的最优解的
 *      3、大问题分解为小问题后，小问题之间还有相互重叠的更小的问题
 *      4、从上往下分析问题，从下往上求解问题（将小问题答案存储起来）
 *
 * 贪心算法：
 *      1、不一定是最优的，想要作为问题最优解的方案，得经过数学验证
 *      2、可使用贪心的情况：整个问题的最优解一定由在贪心策略中存在的子问题的最优解得来的。
 */
