package 排序算法.插入排序;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/12/8 15:15
 */
public class Solution2Test {

    @Test
    public void insertSort() {
        int[] arrays = {2, 5, 1, 3, 4, 6};
        new Solution().insertSort(arrays);
        for (int i :
                arrays) {
            System.out.println(i);
        }
    }
}