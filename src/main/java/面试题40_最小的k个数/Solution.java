package 面试题40_最小的k个数;

/***
 * @author     ：hao
 * @date       ：Created in 2020/6/12 21:25
 * @description：
 **/
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];

        quickSort(arr, 0, arr.length - 1);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private void quickSort(int[] arr, int begin, int end) {
        int left = begin, right = end;

        int pivot = arr[(begin + end) / 2];

        while (left <= right) {
            while (pivot > arr[left]) left++;
            while (pivot < arr[right]) right--;

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        if (left < end) {
            quickSort(arr, left, end);
        }

        if (begin < right) {
            quickSort(arr, begin, right);
        }
    }
}
