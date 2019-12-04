package 面试题5_替换空格;

/**
 * @author Hao
 * @date 2019/11/10 9:58
 */

/*
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

/*
 * 思路
 * 1.考虑是否在原字符串上修改；
 * 2.如果是在原字符串上修改，因为修改后会变长，从后向前替换会减少后移操作。
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        if (count > 0) {
            int oldlen = str.length() - 1;
            int newlen = str.length() + count * 2;
            str.setLength(newlen--);
            while (oldlen >= 0 && count > 0) {
                if (str.charAt(oldlen) == ' ') {
                    str.setCharAt(newlen--, '0');
                    str.setCharAt(newlen--, '2');
                    str.setCharAt(newlen--, '%');
                    oldlen--;
                    count--;
                } else {
                    str.setCharAt(newlen--, str.charAt(oldlen--));
                }
            }
        }
        return str.toString();
    }
}

/*
 * 思路
 * 1.如果可以创建新的字符串，直接从前往后添加，遇到空格替换就行。
 */
class Solution2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer newstr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newstr.append("%20");
            } else {
                newstr.append(str.charAt(i));
            }
        }
        return newstr.toString();
    }
}


/*
 * 总结
 * 1.合并两个数组（包括字符串）时，如果从前往后复制每个数字（或字符）需要重复移动数字（或字符）多次，
 * 那么我们可以考虑从后往前复制，这样能减少移动的次数，从而提高效率。
 */