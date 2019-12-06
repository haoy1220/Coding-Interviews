package 面试题12_矩阵中的路径;

/**
 * @author Hao
 * @date 2019/12/6 21:51
 */

/*
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

/*
 * 思路
 * 运用递归 + 回溯
 */
public class Solution {
    /*
     * @method_name:hasPath
     * @param:  matrix, 矩阵数组
     *          rows, 矩阵行数
     *          cols, 矩阵列数
     *          str, 字符数组（字符串）
     * @return:boolean
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) return false;

        //走过的路径
        boolean visited[] = new boolean[rows * cols];

        //路径长度
        int pathLen = 0;
        //从0行0列开始
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCode(matrix, rows, cols, row, col, str, pathLen, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCode(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLen, boolean[] visited) {
        //如果路径长度已经和字符数组相等，说明可以了
        if (pathLen == str.length) return true;

        //判断还有无路
        boolean hasPath = false;
        //字符相等，则该位置标记为true
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLen]
                && !visited[row * cols + col]) {
            ++pathLen;
            visited[row * cols + col] = true;
            //往上下左右四个方向走
            hasPath = hasPathCode(matrix, rows, cols, row, col - 1, str, pathLen, visited)
                    || hasPathCode(matrix, rows, cols, row - 1, col, str, pathLen, visited)
                    || hasPathCode(matrix, rows, cols, row, col + 1, str, pathLen, visited)
                    || hasPathCode(matrix, rows, cols, row + 1, col, str, pathLen, visited);

            //往下走没有路了则标为false，表示此路不通
            if (!hasPath) {
                --pathLen;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}

/*
 * 总结
 * 回溯要点：
 *      1、终止条件
 *      2、走过的路径标记
 *      3、可走的方向
 *      4、走不通则取消标记
 */