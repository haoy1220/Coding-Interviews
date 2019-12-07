package 面试题13_机器人的运动范围;

/**
 * @author Hao
 * @date 2019/12/7 9:26
 */

/*
 * 题目描述
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */

/*
 * 思路
 * 这题与12题不同的是：
 *      1、12题需要判断是否存在字符串，返回的是boolean，此题需要返回的是机器人的活动范围，即多少个格子，是int
 *      2、12题走过的地方要是回溯了，由于标记被去除了，因此可以重走一遍，而此题走过即是可达的范围，不需要取消标记
 */
public class Solution {
    /*
     * @method_name:movingCount
     * @param:  threshold,
     *          rows,
     *          cols,
     * @return:int
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;

        boolean[] visited = new boolean[rows * cols];
        int pathLen = 0;
        int row = 0;
        int col = 0;
        return hasPathCode(threshold, rows, cols, row, col, visited, pathLen);
    }

    private int hasPathCode(int threshold, int rows, int cols, int row, int col, boolean[] visited, int pathLen) {
        //达到临界条件就返回
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row * cols + col] || count(row, col) > threshold)
            return pathLen;
        //没达到临界条件则说明当前格子可达，标记并将范围pathLen加1
        pathLen++;
        visited[row * cols + col] = true;

        //因为范围是累加的，所以往其它方向走的时候，可以重新计算该方向可达的范围，最后累加到当前的范围即可
        int newPathLen = 0;
        pathLen += hasPathCode(threshold, rows, cols, row, col - 1, visited, newPathLen);
        pathLen += hasPathCode(threshold, rows, cols, row - 1, col, visited, newPathLen);
        pathLen += hasPathCode(threshold, rows, cols, row, col + 1, visited, newPathLen);
        pathLen += hasPathCode(threshold, rows, cols, row + 1, col, visited, newPathLen);
        return pathLen;
    }

    public int count(int rows, int cols) {
        int sum = 0;
        while (rows != 0) {
            sum += rows % 10;
            rows /= 10;
        }

        while (cols != 0) {
            sum += cols % 10;
            cols /= 10;
        }
        return sum;
    }
}
