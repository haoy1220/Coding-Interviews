package 面试题20_表示数值的字符串;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isNumeric() {
        char[] test = {'1','0','0'};
        boolean b = new Solution().isNumeric(test);
        System.out.println(b);
    }

    @Test
    public void isNumeric2() {
        char[] test = {'+','5','0','0'};
        boolean b = new Solution().isNumeric(test);
        System.out.println(b);
    }

    @Test
    public void isNumeric3() {
        char[] test = {'1','2','e'};
        boolean b = new Solution().isNumeric(test);
        System.out.println(b);
    }
}