package 面试题11_旋转数组的最小数字;

/*
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/*
 * 思路
 * 1.考虑数组为0的情况；
 * 2.数组是递增的，将旋转后的数组看成是前后两个数组，要查找的最小元素即为后数组的第一个元素；
 * 3.使用二分查找，若中位数大于前标记，则将前标记更新为中位数；若中位数小于后标记，则将后标记更新为中位数；
 * 4.当前后标记相差为1时，说明后标记即为后数组的第一个元素，也就是目标值。
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int start = 0;
        int end = array.length - 1;
        while (end - start > 1) {
            int mid = (end + start) / 2;
            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }
        }
        return array[end];
    }
}

/*
 * 题目变更：如果存在相同数据
 *
 * 思路
 * 1.多加一个判断，如果中位数和前后标志都相等，则说明存在相同数字，只能使用顺序查找了。
 */
class Solution2 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int start = 0;
        int end = array.length - 1;

        while (array[end] <= array[start]) {
            if (end - start == 1) {
                return array[end];
            }
            int mid = (end + start) / 2;
            if (array[mid] == array[start] && array[mid] == array[end]) {
                return Find(array, start, end);
            } else if (array[mid] <= array[end]) {
                end = mid;
            } else if (array[mid] >= array[start]) {
                start = mid;
            }
        }
        return array[end];
    }

    public static int Find(int[] array, int start, int end) {
        int result = array[start];
        for (int i = start + 1; i < end; i++) {
            if (result > array[i]) {
                result = array[i];
                break;
            }
        }
        return result;
    }
}

/*
 * 总结
 * 1.面试过程要多与面试官交流，询问清楚问题的细节；
 * 2.这道题目隐藏了许多细节：比如，是不是递增数组、存不存在相同数据等情况，不同的情况对应的解都有所变化。
 * 3.考虑各种极端情况，比如：只有1个数字的数组、会不会只旋转了0个数字、空数组等。
 */