package 排序算法.选择排序;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/12/8 17:11
 */
public class SolutionTest {

    @Test
    public void selectSort() {
        int[] arrays = {2, 42, 34, 46, 453, 6};
        new Solution().selectSort(arrays);
        for (int i :
                arrays) {
            System.out.println(i);
        }
    }
}