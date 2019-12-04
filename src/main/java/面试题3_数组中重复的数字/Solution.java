package 面试题3_数组中重复的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hao
 * @date 2019/12/4 22:13
 */

/*
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

/*
 * 思路
 * 使用哈希表
 */
public class Solution {
    /*
     * @method_name:duplicate
     * @param:  numbers,长度为n的数组
     *          length, numbers数组的长度
     *          duplication, 保存第一个重复数字的数组，长度为1
     * @return:boolean
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || length < 2) return false;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else {
                map.put(numbers[i],1);
            }
        }
        duplication[0] = -1;
        return false;
    }
}

/*
 * 思路
 * 因为数组元素在0n-1
 */
class Solution2 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length < 0) return false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else if (numbers[i] < 0 || numbers[i] > length - 1) {
                    return false;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }
}
