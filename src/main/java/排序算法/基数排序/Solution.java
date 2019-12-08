package 排序算法.基数排序;

/**
 * @author Hao
 * @date 2019/11/23 17:43
 */
public class Solution {
    /*
     * @method_name:radixSort
     * @param:[arrays]
     * @return:void
     */
    public void radixSort(int[] arrays) {
        //找出数组最大值做循环条件
        int max = findMax(arrays, 0, arrays.length - 1);

        for (int i = 1; 0 < max / i; i *= 10) {
            int[][] buckets = new int[arrays.length][10];

            //装桶，因为是按顺序排过去的，相同的数顺序不会被打乱，所以是稳定排序
            for (int j = 0; j < arrays.length; j++) {
                int num = (arrays[j] / i) % 10;
                buckets[j][num] = arrays[j];
            }


            int k = 0;

            //10个桶
            for (int j = 0; j < 10; j++) {
                //回收
                for (int l = 0; l < arrays.length; l++) {
                    if (buckets[l][j] != 0) {
                        arrays[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    /*
     * @method_name:findMax, 寻找数组中的最大值，运用的递归
     * @param:  arrays,
     *          start,
     *          end，
     * @return:int
     */
    private int findMax(int[] arrays, int start, int end) {
        if (start == end) {
            return arrays[start];
        } else {
            int a = arrays[start];
            int b = findMax(arrays, start + 1, end);

            if (a < b) {
                return b;
            } else {
                return a;
            }
        }
    }
}
