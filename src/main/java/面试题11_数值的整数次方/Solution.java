package 面试题11_数值的整数次方;

/**
 * @author Hao
 * @date 2019/11/16 10:14
 */

/*
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */

/*
 * 思路
 * 1.考虑特殊情况：输入的指数为0，输入的底数为0，输入的指数为负数
 */
public class Solution {
    public double Power(double base, int exponent) {
        //输入的底数为0
        if (base == 0) return 0;

        //输入的指数为0
        if (exponent == 0) {
            return 1;

            //输入的指数为负数
        } else if (exponent < 0) {
            int exponent_re = -exponent;
            return 1 / PowerWithUnsign(base, exponent_re);

            //正常情况
        } else {
            return PowerWithUnsign(base, exponent);
        }
    }

    public double PowerWithUnsign(double base, int exponent) {
        double result = 1;
        while (exponent != 0) {
            result *= base;
            exponent--;
        }
        return result;
    }
}

/*
 * 思路
 * 考虑到==并不能准确判断小数是否相等，对程序程序规划。
 */

class Solution2 {
    public double Power(double base, int exponent) {
        //输入的底数为0
        if (equal(base, 0.0)) return 0;
        double result = 1;

        //输入的指数为0
        if (exponent == 0) {
            return 1;

            //输入的指数为负数
        } else if (exponent < 0) {
            int exponent_re = -exponent;
            return 1 / PowerWithUnsign(base, exponent_re);

            //正常情况
        } else {
            return PowerWithUnsign(base, exponent);
        }
    }

    public double PowerWithUnsign(double base, int exponent) {
        double result = 1;
        while (exponent != 0) {
            result *= base;
            exponent--;
        }
        return result;
    }


    boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
            return true;
        } else {
            return false;
        }
    }
}

/*
 * 思路
 * 32次方是16次方的平方，16次方是8次方的平方，依此类推，得到结论：
 *         {a^(n/2) * a^(n/2)               ,n为偶
 * a^n =
 *         {a^((n-1)/2) * a^((n-1)/2) * a   ,n为奇
 */

class Solution3 {
    public double Power(double base, int exponent) {
        //输入的底数为0
        if (equal(base, 0.0)) return 0;
        double result = 1;

        //输入的指数为0
        if (exponent == 0) {
            return 1;

            //输入的指数为负数
        } else if (exponent < 0) {
            int exponent_re = -exponent;
            return 1 / PowerWithUnsign(base, exponent_re);

            //正常情况
        } else {
            return PowerWithUnsign(base, exponent);
        }
    }

    public double PowerWithUnsign(double base, int exponent) {
        if (exponent == 1) return base;

        //使用右移实现除以2
        double result = PowerWithUnsign(base, exponent >> 1);
        result *= result;

        //使用与运算判断奇偶性
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }


    boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
            return true;
        } else {
            return false;
        }
    }
}


/*
 * 总结
 * 1.通过功能测试、边界测试、负面测试保证程序的完整性；
 * 2.由于计算机表示小数（包括float和double型小数）都有误差，我们不能直接使用==判断两个小数是否相等。
 * 如果两个小号的差的绝对值很小，比如小于0.0000001，就可以认为它们相等。
 */
