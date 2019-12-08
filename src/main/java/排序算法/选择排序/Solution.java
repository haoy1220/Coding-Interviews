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
    public void selectSort(int[] arrays) {
        //先将最值放到最后一位，剩下0下标时只有一位，不需要再循环
        //故需要n-1趟排序
        for (int i = arrays.length - 1; i > 0; i--) {

            //把最后一个下标假设成最值
            int max = i;

            //从假设最值的前一位下标开始循环，比假设最值大就转移最值下标
            for (int j = i - 1; j >= 0; j--) {
                if (arrays[j] > arrays[max]) {
                    max = j;
                }
            }

            //假设最值下标变换了就交换
            if (max != i){
                int temp = arrays[i];
                arrays[i] = arrays[max];
                arrays[max] = temp;
            }
        }
    }
}
