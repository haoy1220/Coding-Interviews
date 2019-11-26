package 排序算法.归并排序;

/**
 * @author Hao
 * @date 2019/11/23 16:15
 */

/*
 * 思路
 * 将两个排好序的数组合并到一个数组
 *      不断拆分，直到每个数组只包含一个元素；
 *      开始合并（这里合并其实都是合并到原数组，只有拆分的时候才开辟了新的空间）。
 */
public class Solution {
    public void mergeSort(int[] nums) {
        if (nums.length == 0) return;
        splitAndMerge(nums, 0, nums.length - 1);
    }

    public void splitAndMerge(int[] nums, int begin, int end) {
        int mid = (begin + end) / 2;

        //将数组不断拆分成左右两个部分
        splitAndMerge(nums, begin, mid);
        splitAndMerge(nums, mid + 1, end);

        //最后合并处理
        merge(nums, begin, mid + 1, end);

    }

    public void merge(int[] nums, int begin, int midAdd1, int end) {
        //定义一个左边的数组
        int[] leftnums = new int[midAdd1 - begin];

        //定义一个右边的数组
        int[] rightnums = new int[end - midAdd1 + 1];

        //填充数据
        for (int i = begin; i < midAdd1; i++) {
            leftnums[i - begin] = nums[i];
        }
        for (int i = midAdd1; i <= end; i++) {
            rightnums[i - midAdd1] = nums[i];
        }

        int i = 0;
        int j = 0;
        int k = begin;

        //比较两个数组的元素大小，小的先填充到原数组中
        while (i < leftnums.length && j < rightnums.length) {
            if (leftnums[i] < rightnums[j]) {
                nums[k] = leftnums[i];
                i++;
                k++;
            } else {
                nums[k] = rightnums[j];
                j++;
                k++;
            }
        }

        //右边的填充完了，将左边的全部填入(已经排好序了)
        while (i < leftnums.length) {
            nums[k] = leftnums[i];
            i++;
            k++;
        }

        //左边的填充完了，将右边的全部填入(已经排好序了)
        while (j < rightnums.length) {
            nums[k] = rightnums[j];
            k++;
            j++;
        }
    }
}
