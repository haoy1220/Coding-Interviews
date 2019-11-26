package 排序算法.堆排序;

/**
 * @author Hao
 * @date 2019/11/23 17:44
 */
public class Solution {
    public void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            maxHeapify(nums, nums.length - 1);
            int temp = nums[0];
            nums[0] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

    }

    public void maxHeapify(int[] nums, int size) {
        for (int i = size - 1; i >= 0; i--) {
            heapify(nums, i, size);
        }
    }

    public void heapify(int[] nums, int root, int size) {
        if (root < size) {
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            int max = root;

            if (left < size) {
                if (nums[max] < nums[left]) {
                    max = left;
                }
            }

            if (right < size) {
                if (nums[max] < nums[right]) {
                    max = right;
                }
            }

            if (max != root) {
                int temp = nums[max];
                nums[max] = nums[root];
                nums[root] = temp;

                heapify(nums, max, size);
            }
        }
    }
}
