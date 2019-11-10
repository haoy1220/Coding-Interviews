package 面试题3_二维数组中的查找;

/**
 * @author Hao
 * @date 2019/11/10 9:36
 */

/*
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

/*
 * 思路
 * 1.矩阵是有序的，从左下角来看，向上数字递减，向右数字递增；
 * 因此从左（右）下角开始查找，当要查找数字比左（右）下角数字大时，右（下）移；
 * 要查找数字比左（右）下角数字小时，上（左）移；
 * 2.考虑空矩阵的可能情况。
 */
public class Solution {
    public boolean Find(int target, int[][] array) {

        int column = array[0].length - 1;//注意下标的值，不然会发生下标越界
        int row = 0;
        if (array != null) {
            while (column >= 0 && row < array.length) {
                if (array[row][column] > target) {
                    column--;
                } else if (array[row][column] < target) {
                    row++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}


/*
 * 总结
 * 1.尽可能让多方向的结果往两个方向上发展，便于操作。
 */