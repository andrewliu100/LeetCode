package com.leetcode;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */
public class WordSearch {

    /**
     * DFS + Backtracking
     *
     * Time complexity: O(m*n*4^k). m * n is the size of the grid, k is the length of the word.
     * Space complexity: O(k). k is the length of the word. Recursion call stack.
     */
    public boolean exist(char[][] grid, String word) {
        if (grid.length == 0 || grid[0].length == 0) {
            return false;
        }

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(word, grid, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(String word, char[][] grid, int k, int x, int y) {
        if (k == word.length()) {
            return true;
        }
        int m = grid.length;
        int n = grid[0].length;
        char ch = word.charAt(k);
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == ch) {
            grid[x][y] = '~';
            // search north
            if (search(word, grid, k + 1, x - 1, y)) {
                return true;
            }
            // search south
            if (search(word, grid, k + 1, x + 1, y)) {
                return true;
            }
            // search west
            if (search(word, grid, k + 1, x, y - 1)) {
                return true;
            }
            // search east
            if (search(word, grid, k + 1, x, y + 1)) {
                return true;
            }
            grid[x][y] = ch;
        }
        return false;
    }
}
