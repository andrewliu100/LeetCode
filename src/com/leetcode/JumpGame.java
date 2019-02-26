package com.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    /**
     * Backtracking.
     * Time Complexity: O(2^n). n is the number of integers in the array.
     *
     * The time complexity if the total number of possible ways jump from 0 to n - 1, because
     * we potentially try all the ways until we reach n - 1.
     *
     * Let T(x) be the number of ways jump from x to n - 1.
     * Because from x, we can jump to x + 1, x + 2, ..., n - 2, n - 1 first, then we jump from
     * there to n - 1.
     *
     * T(x) = T(x+1) + T(x+2) + ... + T(n-1)
     * T(x+1) = T(x+2) + T(x+3) + ... + T(n-1)
     * => T(x) = T(x+1) + T(x+1) = 2*T(x+1)
     * => T(x) = 2*2*T(x+2) = 2^2*T(x+2)
     * => T(x) = 2^n*T(x+n)
     * => T(x) = 2 ^ (n-x)T(n)
     *    T(n) = 1, jumping from n to n has only 1 way
     * => T(x) = 2 ^ (n-x).
     *
     * Space Complexity: O(n). Recursion call stack.
     */
    public boolean canJump1(int[] nums) {
        return helper(0, nums);
    }

    private boolean helper(int pos, int[] nums) {
        if (pos == nums.length - 1) {
            return true;
        }
        int furthestPos = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = pos + 1; nextPos <= furthestPos; nextPos++) {
            if (helper(nextPos, nums)) {
                return true;
            }
        }
        return false;
    }

    /**
     * DP.
     *
     * Time Complexity: O(n^2). n is the number of integers in the array.
     * Space Complexity: O(n). n is the number of integers in the array.
     */
    public boolean canJump2(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[nums.length - 1] = true;
        for (int i = nums.length - 2; i >=0; i--) {
            int furthestPos = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestPos; j++) {
                if (memo[j]) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[0];
    }

    /**
     * Greedy.
     *
     * O(n)
     */
    public boolean canJump3(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
