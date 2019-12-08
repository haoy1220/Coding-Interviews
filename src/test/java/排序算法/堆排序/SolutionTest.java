package 排序算法.堆排序;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/12/8 23:44
 */
public class SolutionTest {

    @Test
    public void heapSort() {
        int[] arrays = {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1, 5, 2, 5};
        new Solution().heapSort(arrays);
        for (int i:
             arrays) {
            System.out.println(i);

        }
    }
}