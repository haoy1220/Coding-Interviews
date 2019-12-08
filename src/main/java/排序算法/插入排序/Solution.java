package 排序算法.插入排序;

/**
 * @author Hao
 * @date 2019/11/23 13:39
 */

/*
 * 思路
 * 将一个元素插入到有序数组中；
 * 因为初始时并不知道数组是否有序，所以将第一个数视为有序数组提供给后续元素插入；
 * 因为第一个元素不需要插入，故只需要n-1趟排序。
 */
public class Solution {
    public void insertSort(int[] nums) {

        //将第1个数当作有序数组，所以从1开始
        for (int i = 1; i < nums.length; i++) {

            int temp = nums[i];

            //向前比较，并记录位置
            while (i - 1 >= 0 && nums[i - 1] > temp) {
                nums[i] = nums[i - 1];
                i--;
            }

            //找到合适的位置了，插入
            nums[i] = temp;
        }
    }
}

/**
 * 优化
 * 因为循环使用的i和后退使用的i一致，可能会造成不必要的浪费;
 * 使用一个临时变量来代替i进行后退记录。
 */
class Solution2 {
    public void insertSort(int[] nums) {

        //将第1个数当作有序数组，所以从1开始
        for (int i = 1; i < nums.length; i++) {

            int temp = nums[i];
            //另起一个变量来进行后退记录
            int tempi = i;

            ////向前比较，并记录位置
            while (tempi - 1 >= 0 && nums[tempi - 1] > temp) {
                nums[tempi] = nums[tempi - 1];
                tempi--;
            }

            //找到合适的位置了，插入
            nums[tempi] = temp;
        }
    }
}