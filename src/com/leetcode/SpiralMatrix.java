package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    /**
     * O(m*n)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length > 0 && matrix[0].length > 0) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] visited = new boolean[m][n];
            int[] rd = new int[] {0, 1, 0, -1};
            int[] ld = new int[] {1, 0, -1, 0};
            int direction = 0;
            int i = 0, j = 0;
            while (res.size() < m * n) {
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i = i + rd[direction % 4];
                j = j + rd[direction % 4];
                if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
                    i = i - rd[direction % 4];
                    j = j - rd[direction % 4];
                    direction++;
                    i = i + rd[direction % 4];
                    j = j + rd[direction % 4];
                }
            }
        }
        return res;
    }
}
