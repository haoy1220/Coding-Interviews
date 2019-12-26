package 面试题19_正则表达式匹配;

/*
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

/*
 * 思路
 * 第二个模式是'*':
 *  一、第一个字符匹配上：
 *      1、啥都匹配不到，跳过
 *      2、匹配到1个
 *      3、匹配到多个 //有个大问题，'.*'可以匹配完所有的字符组合
 *  二、第一个字符没有匹配上：
 *      1、啥都匹配不到，跳过
 *
 * 第二个模式不是'*':
 *  一、第一个字符匹配上:下一个字符继续匹配
 *  二、没匹配上，错了，返回
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        //模式为空，得看字符串
        if (pattern == null) return str == null;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //字符串到尾了，模式也到尾了
        if (strIndex == str.length && patternIndex == pattern.length) return true;

        //字符串还没到尾，模式到尾了
        if (strIndex != str.length && patternIndex == pattern.length) return false;

        //字符串到尾了，模式还没到尾
        //字符串还没到尾，模式还没到尾
        //模式第二个是'*'
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //第一个字符匹配上，或第一个模式字符是'.'
            if (strIndex != str.length && str[strIndex] == pattern[patternIndex] || strIndex != str.length && pattern[patternIndex] == '.') {
                //判断里strIndex != str.length && pattern[patternIndex] == '.'必须加上，防止在".*"模式不变的情况下，字符串已经为空了却无限匹配成功，导致数组越界的问题
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                //第一个没匹配上，就跳过咯
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if (strIndex != str.length && str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'){
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }else {
            return false;
        }

    }

}

/*
 * 总结
 * 1、因为strIndex每次只加1，可以使用！=来判断
 * 2、'.*'可以匹配完所有的字符组合，"bcbbabab"，".*a*a"，这个用例是靠字符串变为空来结束循环的，而不是匹配完一个字符，第二个字符不同就通过这个模式了
 */
