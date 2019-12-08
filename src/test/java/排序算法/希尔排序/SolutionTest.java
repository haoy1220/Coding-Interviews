package 排序算法.希尔排序;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/12/8 15:12
 */
public class SolutionTest {

    @Test
    public void shellSort() {
        int[] arrays = {2, 5, 1, 3, 4, 6};
        new Solution().shellSort(arrays);
        for (int i :
                arrays) {
            System.out.println(i);
        }
    }
}