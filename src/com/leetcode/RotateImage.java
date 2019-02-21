package com.leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 *  - You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 *  DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class RotateImage {

    /**
     * https://leetcode.com/problems/rotate-image/discuss/235478/Success%3ASimple-java-solution-beats-100-of-online-submission-explained-in-detail
     *
     * Rotate from outer to inner
     * [1,  2 ,  3,  4,  5]
     * [6,  7 ,  8,  9, 10]
     * [11, 12, 13, 14, 15]
     * [16, 17, 18, 19, 20]
     * [21, 22, 23, 24, 25]
     *
     * Rotate 1:
     * [1,  2 ,  3,  4,  5]
     * [6               10]
     * [11              15]
     * [16              20]
     * [21, 22, 23, 24, 25]
     *
     * Rotate 2:
     * [7 ,  8,  9]
     * [12      14]
     * [17, 18, 19]
     *
     * Rotate 3:
     * [13]
     *
     * Rotation index calculation:
     * last = n - 1 - i
     * offset = j - i
     *        (i, j)      ->  (i + offset, last)
     *          ^                   |
     *          |                   v
     * (last - offset, i) <-  (last, last - offset)
     *
     * O(n^2)
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i <= n/2; i++) {
            int last = n - 1 - i;
            for (int j = i; j < last; j++) {
                int offset = j - i;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[last - offset][i];
                matrix[last - offset][i] = matrix[last][last- offset];
                matrix[last][last - offset] = matrix[i + offset][last];
                matrix[i + offset][last] = tmp;
            }
        }
    }

    /**
     * transpose first then reverse. O(n^2)
     */
    public void rotate2(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    /**
     *  O(n^2)
     *  [1,  2,  3,   4]     [13, 14, 15, 16]
     *  [5,  6,  7,   8]  -> [9 , 10, 11, 12]
     *  [9,  10, 11, 12]     [5 , 6 , 7 ,  8]
     *  [13, 14, 15, 16]     [1 , 2 , 3 ,  4]
     */
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 -i][j] = tmp;
            }
        }
    }

    /**
     *  O(n^2)
     * [13, 14, 15, 16]     [13, 9,  5, 1]
     * [9 , 10, 11, 12]  -> [14, 10, 6, 2]
     * [5 , 6 , 7 ,  8]     [15, 11, 7, 3]
     * [1 , 2 , 3 ,  4]     [16, 12, 8, 4]
     */
    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

}
