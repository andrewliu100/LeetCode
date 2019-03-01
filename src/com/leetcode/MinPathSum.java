package com.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinPathSum {

    private int minPath = Integer.MAX_VALUE;
    private int endX;
    private int endY;

    /**
     * Backtracking.
     *
     * Time complexity: O(?)
     * Space complexity: O(m * n)
     *
     */
    public int minPathSum1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        endX = grid.length - 1;
        endY = grid[0].length - 1;
        helper(grid, grid[0][0], 0, 0);
        return minPath;
    }

    private void helper(int[][] grid, int pathSum, int x, int y) {
        if (x == endX && y == endY) {
            minPath = Math.min(minPath, pathSum);
        }

        if (y < endY) {
            helper(grid, pathSum + grid[x][y + 1], x, y + 1);
        }

        if (x < endX) {
            helper(grid, pathSum + grid[x + 1][y], x + 1, y);
        }
    }

    /**
     * DP.
     *
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     *
     */
    public int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] minPaths = new int[m][n];
        minPaths[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            minPaths[i][0] = minPaths[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            minPaths[0][j] = minPaths[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minPaths[i][j] = minPaths[i - 1][j] + minPaths[i][j - 1];
            }
        }
        return minPaths[m - 1][n - 1];
    }
}
