package 面试题17_打印1到最大的n位数;

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
 * 如果出现非常大的位数，那么使用常规解法就会发生溢出，考虑使用字符串或数组表示
 */
class Solution2 {
    public void PrintLargest(int n) {
        if (n <= 0) return;
        char[] chars = new char[n];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '0';
        }

        while (!incrementNumber(chars)) {
            printNumber(chars);
        }
    }

    private void printNumber(char[] chars) {
        boolean isBeginning = true;
        int len = chars.length;
        for (int i = 0; i < len; ++i) {
            if (isBeginning && chars[i] != '0') {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.print(chars[i]);
            }

        }
        System.out.println();
    }

    private boolean incrementNumber(char[] chars) {
        boolean isOverflow = false;
        int TakeOver = 0;
        int len = chars.length;
        for (int i = len - 1; i >= 0; --i) {
            int sum = chars[i] - '0' + TakeOver;
            if (i == len - 1) {
                ++sum;
            }
            if (sum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    sum -= 10;
                    TakeOver = 1;
                    chars[i] = (char) ('0' + sum);
                }
            } else {
                chars[i] = (char) ('0' + sum);
                break;
            }
        }
        return isOverflow;
    }
}

/*
 * 思路
 * 把问题转化为数字排列的解法，使用递归可以使代码简洁明了。
 * 即：如果在所有的数字前面补0的话，就会发现n位所有的十进制数其实就是n个从0到9的全排列。
 * 也就是说，我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。在打印时，数字排在前面的0不打印。
 * 全排列递归实现最容易。数字的每一位都可能是0到9的一个数，然后设置下一位。
 * 递归结束的条件就是我们已经设置了数字的最后一位。
 */
class Solution3 {
    public void PrintLargest(int n) {
        if (n <= 0) return;
        char[] chars = new char[n];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '0';
        }

        for (int i = 0; i < 10; i++) {
            chars[0] = (char) (i + '0');
            incrementNumber(chars, n, 0);
        }
    }

    private void incrementNumber(char[] chars, int n, int index) {
        if (index == n - 1) {
            printNumber(chars);
            return;
        }
        for (int j = 0; j < 10; j++) {
            chars[index + 1] = (char) (j + '0');
            incrementNumber(chars, n, index + 1);
        }
    }

    private void printNumber(char[] chars) {
        boolean isBeginning = true;
        int len = chars.length;
        for (int i = 0; i < len; ++i) {
            if (isBeginning && chars[i] != '0') {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.print(chars[i]);
            }

        }
        System.out.println();
    }


}
/*
 * 总结
 * 1.考虑到大数会溢出，最常用的是用字符串或数组表达大数；
 * 2.char默认值是空值'';
 */