package 面试题10_斐波那契数列;

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
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

/*
 * 思路
 * 1.先看0、1、2阶的情况；
 * 2.0阶即为0；1阶也只有一种，计为1；
 * 3.2阶可以分1阶1阶跳，或者2阶一起跳，有两种情况；
 * 4.而第3阶发现可能有两种情况，即最后一次跳1阶到达，对应的可能情况种数是跳2阶时的数目（因为最后一跳固定是跳1阶）；
 * 或者最后一次跳2阶到达，对应的可能情况种数是跳1阶时的数目（因为最后一跳固定是跳2阶）；
 * 5.所以第3阶的可能种数为跳2阶加上跳1阶时的种数和，即f(3) = f(2) + f(1);
 * 6.依此类推，第4，5，6......n时对应的种数应该为f(n) = f(n-1) + f(n-2).
 */

class Solution3 {
    public int JumpFloor(int target) {
        int[] result = {0, 1, 2};
        if (target < 3) return result[target];

        int n_1 = result[2];
        int n_2 = result[1];
        int re = 0;
        for (int i = 3; i <= target; i++) {
            re = n_1 + n_2;
            n_2 = n_1;
            n_1 = re;
        }
        return re;
    }
}

/*
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

/*
 * 思路
 * 1.同上一样分析，在最后一个台阶反推可能的步数，比如第n阶最后一跳可能是n（也即是跳一次就到了，所以下面式子后面加上了1）、n-1、n-2、...、1；
 * 2.总结公式为：f(n) = f(n-1) + f(n-2) + ... + f(1) + 1;
 * 3.故f(n-1) = f(n-2) + f(n-3) + ... + f(1) + 1;
 * 4.两式相减得：f(n) = 2 * f(n-1)。
 */
class Solution4 {
    public int JumpFloorII(int target) {
        //按f(n) = f(n-1) + f(n-2) + ... + f(1) + 1的写法
//        int[] result = {0, 1, 2};
//        if (target < 3) return result[target];
//
//        int sum = result[1] + result[2];
//        int one = 1;
//        int re = 0;
//        for (int i = 3; i <= target; i++) {
//            re = sum + one;
//            sum += re;
//        }
//        return re;

        //按f(n) = 2 * f(n-1)的写法
        if (target < 0) {
            return -1;
        } else if (target == 0 || target == 1) {
            return target;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}

/*
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

/*
 * 思路
 * 1.和青蛙跳一样，当要覆盖2*1的矩形时，只能竖着放，有1种方法；
 * 2.当要覆盖2*2的矩形时，可以竖着放或横着放，有2种方法；
 * 3.当要覆盖2*3的矩形时，最后可能竖着放或横着放，竖着放和2*2的放法一样多，横着放和2*1的放法一样多。
 * 4.继续往下分析可以发现，依然是f(n) = f(n-1) + f(n-2)的规律。
 */
class Solution5 {
    public int RectCover(int target) {
        int[] result = {0, 1, 2};
        if (target < 3) return result[target];

        int n_1 = result[2];
        int n_2 = result[1];
        int re = 0;
        for (int i = 3; i <= target; i++) {
            re = n_1 + n_2;
            n_2 = n_1;
            n_1 = re;
        }
        return re;
    }
}


/*
 * 总结
 * 1.对于列举情况的题目，可以从后往前推演试试找出规律；
 * 2.对于返回值中有两个计算方法的递归，可能会损耗更大的空间或时间，可以考虑用常规的顺序计算去解决，而只有一个计算方法的递归影响不大。
 */
