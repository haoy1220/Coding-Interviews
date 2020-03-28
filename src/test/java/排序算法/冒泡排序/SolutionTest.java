package 排序算法.冒泡排序;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/12/8 16:44
 */
public class SolutionTest {

    @Test
    public void bubbleSort() {
        int[] arrays = {2, 42, 34, 46, 453, 6};
        new Solution().bubbleSort(arrays);
        for (int i :
                arrays) {
            System.out.println(i);
        }
    }
}
