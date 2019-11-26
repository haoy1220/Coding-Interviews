package 排序算法.选择排序;

/**
 * @author Hao
 * @date 2019/11/23 13:40
 */

/*
 * 思路
 * 找到最大的元素，与数组最后一位交换；
 * 当只有一个数时，则不需要选择了，因此需要n-1趟排序。
 */
public class Solution {
    public void selectSort(int[] nums) {
        //n-1趟排序
        for (int i = 0; i < nums.length - 1; i++) {

            //标记最大值的下标
            int max = 0;

            //每一趟过后少比较一位，即n-i次比较
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[max] < nums[j]) {
                    max = j;
                }
            }

            //如果最大值不是当前最后一位就交换
            if (max != nums.length - 1 - i) {
                int temp = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = nums[max];
                nums[max] = temp;
            }
        }
    }
}
