package com.leetcode;

import java.math.BigInteger;

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
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {

    private int count = 0;
    private int endX;
    private int endY;

    /**
     * Backtracking.
     *
     * Time complexity: O(?)
     * Space complexity: O(m * n). Recursion call stack
     */
    public int uniquePaths1(int m, int n) {
        endX = m - 1;
        endY = n - 1;
        helper(0, 0);
        return count;
    }

    private void helper(int x, int y) {
        if (x == endX && y == endY) {
            count++;
            return;
        }

        if (y < endY) {
            helper(x, y + 1);
        }
        if (x < endX) {
            helper(x + 1, y);
        }
    }

    /**
     * DP.
     * Time complexity: O(m * n)
     * Space complexity: O(m * n)
     */
    public BigInteger uniquePaths2(int m, int n) {
        BigInteger[][] memo = new BigInteger[m][n];

        for (int i = 0; i < m; i++) {
            memo[i][0] = new BigInteger("1");
        }
        for (int j = 0; j < n; j++) {
            memo[0][j] = new BigInteger("1");;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j].add(memo[i][j - 1]);
            }
        }
        return memo[m - 1][n - 1];
    }

}
