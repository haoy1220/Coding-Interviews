package 面试题11_旋转数组的最小数字;

import static org.junit.Assert.*;

public class Solution2Test {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] array = {1,0,1,1,1,1};
        int[] zero = {1};
        System.out.println(solution2.minNumberInRotateArray(zero));
    }

}