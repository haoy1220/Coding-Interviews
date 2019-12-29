package 面试题29_顺时针打印矩阵;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (matrix.length == 0) return arrayList;

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] seen = new boolean[rows][cols];

        //行走的方向，由di % 4来控制转向
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int di = 0;

        int row = 0;
        int col = 0;

        for (int i = 0; i < rows * cols; i++) {
            arrayList.add(matrix[row][col]);
            seen[row][col] = true;
            int nextRow = row + dr[di];
            int nextCol = col + dc[di];

            //判断是否需要转向
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !seen[nextRow][nextCol]) {
                //不转向就直接赋予下一步
                row = nextRow;
                col = nextCol;
            } else {
                //转个向再赋予下一步
                di = (di + 1) % 4;
                row += dr[di];
                col += dc[di];
            }

        }

        return arrayList;

    }
}



