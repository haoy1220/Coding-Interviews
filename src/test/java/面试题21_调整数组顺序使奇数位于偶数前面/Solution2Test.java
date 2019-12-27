package 面试题21_调整数组顺序使奇数位于偶数前面;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void reOrderArray() {
        int[] arrays = {2, 4, 1, 3, 56, 24, 62, 63, 6};
        new Solution2().reOrderArray(arrays);
        for (int i:
                arrays) {
            System.out.print(i+ "  ");
        }
    }
}