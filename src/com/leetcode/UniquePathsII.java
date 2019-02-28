package com.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'S' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'F' in the diagram below).
 *
 * ----------------
 * |S |  |  |  |  |
 * ----------------
 * |  |  |  |  |  |
 * ----------------
 * |  |  |  |  | F|
 * ----------------
 *
 * How many possible unique paths are there?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 */
public class UniquePathsII {

    private int count = 0;
    private int endX;
    private int endY;
    /**
     * Backtracking.
     *
     * Time complexity: O(?)
     * Space complexity: O(m * n)
     */
    public int uniquePaths1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        endX = grid.length - 1;
        endY = grid[0].length - 1;
        helper(grid, 0, 0);
        return count;
    }

    private void helper(int[][] grid, int x, int y) {
        if (grid[x][y] == 1) {
            return;
        }
        if (x == endX && y == endY) {
            count++;
            return;
        }

        if (x < endX) {
            helper(grid, x + 1, y);
        }
        if (y < endY) {
            helper(grid, x, y + 1);
        }
    }

    /**
     * DP
     *
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     */
    public int uniquePath2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = grid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i < m; i++) {
            paths[i][0] = grid[i][0] == 1 ? 0 : paths[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            paths[0][j] = grid[0][j] == 1 ? 0 : paths[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = grid[i][j] == 1 ? 0 : paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

}
