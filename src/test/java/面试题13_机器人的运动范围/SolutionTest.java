package 面试题13_机器人的运动范围;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hao
 * @date 2019/12/7 9:37
 */
public class SolutionTest {

    @Test
    public void count() {
        int rows = 35;
        int cols =37;
        int sum = new Solution().count(rows,cols);
        System.out.println(sum);
    }
}