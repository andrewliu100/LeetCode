package com.leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    int count = 0;
    /**
     * Backtracking
     *
     * Time complexity: O(2^n). n is the length of s.
     * Space complexity: O(n). Recursion call stack.
     *
     */
    public int numDecodings1(String s) {
        if (s.length() == 0) {
            count++;
        } else {
            for (int i = 1; i <= 2; i++) {
                if (i <= s.length() && s.charAt(0) != '0') {
                    if (isValid(s.substring(0, i))) {
                        numDecodings1(s.substring(i));
                    }
                }
            }
        }
        return count;
    }

    /**
     * DP
     *
     * Time complexity: O(n). n is the length of s.
     * Space complexity: O(n). n is the length of s.
     *
     */
    public int numDecodings2(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                memo[i] = isValid(s.substring(i, i + 2)) ? memo[i - 2] + memo[i - 1] : memo[i - 1];
            } // if (s.charAt(i) == '0') memo[i] = 0;
        }
        return memo[0];
    }

    private boolean isValid(String s) {
        int letter = Integer.valueOf(s);
        return letter >= 1 && letter <= 26;
    }

}
