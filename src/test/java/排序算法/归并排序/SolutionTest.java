package 排序算法.归并排序;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/12/8 23:09
 */
public class SolutionTest {

    @Test
    public void mergeSort() {
        int[] arrays = {2, 5, 1, 3, 4, 6};
        new Solution().mergeSort(arrays);
        for (int i :
                arrays) {
            System.out.println(i);
        }
    }
}