package 排序算法.冒泡排序;

/**
 * @author Hao
 * @date 2019/11/23 13:05
 */

/*
 * 思路
 * 俩俩交换比较大小，大的放在后面，第一遍后最大的移到到最后一位；
 * 因为俩俩交换，需要n-1趟排序，比如10个元素，需要9趟排序。
 */
public class Solution {
    public void bublleSort(int[] nums) {
        //排序n-1趟
        for (int i = 0; i < nums.length - 1; i++) {

            //i趟过后只要n-1-i次排序
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}


/**
 * 优化
 * 考虑到可能提前排好，使用一个标记记录是否发生交换。
 */
class Solution2 {
    public void bublleSort(int[] nums) {
        //排序n-1趟
        for (int i = 0; i < nums.length - 1; i++) {

            boolean isChange = false;

            //i趟过后只要n-1-i次排序
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    //发生交换就标记
                    isChange = true;
                }
            }

            //标记为false说明已经排好，可以结束了
            if (!isChange) break;
        }
    }
}