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
    public void mergeSort(int[] arrays) {
        if (arrays.length == 0) return;
        _mergeSort(arrays, 0, arrays.length - 1);
    }

    private void _mergeSort(int[] arrays, int start, int end) {
        //只有一个元素就不用再分了
        if (start == end) {
            return;
        } else {
            int mid = (start + end) / 2;
            _mergeSort(arrays, start, mid);
            _mergeSort(arrays, mid + 1, end);
            //开始合并
            merge(arrays, start, mid, end);
        }
    }

    private void merge(int[] arrays, int start, int mid, int end) {
        //创建两个数组
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];


        //给两个数组填充数据
        for (int i = start; i <= mid; i++) {
            left[i - start] = arrays[i];
        }
        for (int i = mid + 1; i <= end; i++) {
            right[i - mid - 1] = arrays[i];
        }

        int i = 0;
        int j = 0;
        int k = start;

        //两个数组从头开始比大小，填充到原数组上
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arrays[k++] = left[i++];
            } else {
                arrays[k++] = right[j++];
            }
        }

        //右边的用完了，左边的满上
        while (i < left.length) {
            arrays[k++] = left[i++];
        }

        //左边的用完了，右边满上
        while (j < right.length) {
            arrays[k++] = right[j++];
        }
    }
}
