package 面试题38_字符串的排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * description: TODO
     *
     * @Param: null
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        //保存结果
        ArrayList<String> list = new ArrayList<String>();

        //判空
        if (str != null && str.length() > 0){
            //开始递归
            PermutationHelper(str.toCharArray(), 0, list);
            //排序
            Collections.sort(list);
        }
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> characterSet = new HashSet<Character>();
            for (int j = i; j < chars.length; j++) {
                if (j == i || !characterSet.contains(chars[j])){
                    characterSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j , i);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
