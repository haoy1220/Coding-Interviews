package 面试题59_队列的最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ：hao
 * @date ：Created in 2020/3/27 15:36
 * @description：队列（滑动窗口）的最大值
 */
//双向队列解法
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<Integer>();//返回结果
        if (size == 0) return res;//长度为0直接返回

        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < num.length; i++) {
            //当下标为0时，还差2个数值滑动窗口才完整，这时候是不能保存最大值的，所以要用begin控制
            begin = i - size + 1;
            if (!q.isEmpty() && begin > q.peekFirst()) {//判断队首元素是否已经超出当前滑动窗口的范围了，超出就丢弃，防止后面的比较判断
                q.pollFirst();
            }

            //丢弃比新增的值小的下标
            while (!q.isEmpty() && num[q.peekLast()] <= num[i]) {
                q.pollLast();
            }

            q.add(i);

            if (begin >= 0) {//可以开始保存结果了
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}




