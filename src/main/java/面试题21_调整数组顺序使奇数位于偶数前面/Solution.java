package 面试题21_调整数组顺序使奇数位于偶数前面;

/*
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分.
 */
public class Solution {
    public void reOrderArray(int[] array) {
        if (array == null) return;

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }

            while (left < right && array[right] % 2 != 1) {
                right--;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

        }

    }

}


/*
 * 题目扩展
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 使得函数可以满足任意判定条件，而不需要改变原函数体
 */
class Solution2 {
    public void reOrderArray(int[] array) {
        if (array == null) return;

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            while (left < right && !Solution2.isEvent(array[left])) {
                left++;
            }

            while (left < right && Solution2.isEvent(array[right])) {
                right--;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

        }
    }

    private static boolean isEvent(int n) {
        return n % 2 == 0;
    }
}

/*
 * 题目扩展
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

/*
 * 思路
 * 通过一个稳定排序算法进行变形即可，如下面使用的直接插入排序算法
 */
class Solution3 {
    public void reOrderArray(int[] array) {
        //判空
        if (array == null) return;

        //第一个不用排，当成已排好序
        for (int i = 1; i < array.length; i++) {

            //记录当前位数据
            int temp = array[i];

            //记录当前下标
            int j = i;

            /**
             * 插入依据
             * 1、当前值为偶数就不动，如果是奇数才需要前移
             * 2、前一位是否存在
             * 3、前一位如果是偶数就往后移，继续往前判断，直到不是偶数为止
             */
            while (temp % 2 != 0 && j - 1 >= 0 && array[j - 1] % 2 == 0) {
                array[j] = array[j - 1];
                j--;
            }

            //找到该插入的位置了
            array[j] = temp;
        }

    }

}