package 排序算法.希尔排序;

/**
 * @author Hao
 * @date 2019/11/23 17:44
 */
public class Solution {
    public void shellSort(int[] arrays) {
        //增量每次/2
        for (int step = arrays.length / 2; step > 0; step /= 2) {

            //进行插入排序，相隔一个增量的距离进行比较
            for (int i = step; i < arrays.length; i++) {
                int j = i;
                int temp = arrays[j];

                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
    }

}
