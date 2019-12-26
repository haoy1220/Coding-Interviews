package 面试题19_正则表达式匹配;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void match() {
        char[] chars1 = new char[0];
        char[] chars2 = {'.','*'};
        new Solution().match(chars1,chars2);
    }

    @Test
    public void match2(){
        char[] chars1 = new char[0];
        char[] chars2 = {'.'};
        new Solution().match(chars1,chars2);
    }

    @Test
    public void match3(){
        char[] chars1 = "bcbbabab".toCharArray();
        char[] chars2 = ".*a*a".toCharArray();
        new Solution().match(chars1,chars2);
    }
}