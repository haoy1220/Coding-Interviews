package 面试题20_表示数值的字符串;


/*
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {

    //用来指定当前所指的元素
    private static int index = 0;

    public boolean isNumeric(char[] str) {
        //判空
        if (str == null) {
            return false;
        }

        //不置0会在多用例的情况下会有影响
        index = 0;

        //判断整数段
        boolean numeric = scanInteger(str);

        //判断小数段
        if (index < str.length && str[index] == '.') {
            index++;

            /**
             * 使用||
             * 1、可以只有小数，没有整数
             * 2、可以只有整数，没有小数
             * 3、可以整数、小数都有
             */
            numeric = scanUnsignedInteger(str) || numeric;
        }

        //判断指数段
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;

            /**
             * 使用&&
             * 1、指数前必须带数值
             * 2、e之后也要带数值
             */
            numeric = numeric && scanInteger(str);
        }

        return numeric && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')){
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int before = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > before;
    }

}
