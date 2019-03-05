package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 *
 * Example 2:
 *
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 *
 */
public class SetMatrixZeroes {

    /**
     * !Trick!
     *
     * This can be easily done in space complexity of O(m + n).
     * To do this with O(1) space complexity, use the row 0 and column 0
     * as flag of whether need to set the entire row/column to zeroes.
     *
     */

    /**
     * Use extra set to record which rows/cols need to be set to zero
     *
     * Time complexity: O(m*n)
     * Space complexity: O(m + n)
     */
    public void setZeroes1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Use row 0 and column 0 as flags
     *
     * Time complexity: O(m*n)
     * Space complexity: O(1)
     *
     */
    public void setZeros2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Need an extra variable for column 0
        boolean isSetCol0 = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isSetCol0 = true;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // set zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set row 0
        if (matrix[0][0] == 0) {
            for (int j = 1; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // set column 0
        if (isSetCol0) {
            for (int i = 1; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
