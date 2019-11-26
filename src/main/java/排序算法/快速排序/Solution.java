package 排序算法.快速排序;

/**
 * @author Hao
 * @date 2019/11/23 14:54
 */

/*
 * 思路
 * 在数组中找一个支点，将比它大的都放到右边，比它小的都放到左边，接着不断对左右两边执行相同的操作；
 * 由此我们可以使用递归解决，使用取中切分确定支点；
 * 使用{1, 2, 3, 4, 3, 2, 1}这个用例可以解开很多特殊情况的疑惑。
 */
public class Solution {
    public void quickSort(int[] nums) {
        if (nums.length == 0) return;
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int begin, int end) {
        int i = begin;
        int j = end;

        //先将中间点当作支点，左边全小于中间点，右边全大于中间点
        int pivot = nums[(begin + end) / 2];

        //左右两端扫描，直到两端交替错开
        while (i <= j) {

            //找到比支点大的i
            while (pivot > nums[i]) {
                i++;
            }

            //找到比支点小的j
            while (pivot < nums[j]) {
                j--;
            }

            //将找到的i、j对应位的值交换，然后继续下一位
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        //左边递归，结束条件就是当只有一个元素的时候
        if (begin < j) {
            sort(nums, begin, j);
        }

        //右边递归，结束条件就是当只有一个元素的时候
        if (end > i) {
            sort(nums, i, end);
        }
    }
}
