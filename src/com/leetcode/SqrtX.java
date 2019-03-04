package com.leetcode;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 */
public class SqrtX {

    /**
     * !Trick!
     *
     * Let i be the square root of x.
     *
     * Important observations:
     * 1. i * i <= x and (i + 1) * (i + 1) > x
     * 2. i * i might be overflow, while x/i will not. So we process i <= x/i instead
     *
     */

    /**
     * Binary search.
     *
     * Time complexity: O(logx) => O(1). Max integer is 2^31 -1 => O(31) => O(1)
     * Space complexity: O(1)
     *
     */
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }

        int lo = 1;
        int hi = x;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }

            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * Brute force.
     *
     * Time complexity: O(sqrt(x))
     * Space complexity: O(1)
     *
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        for (int i = 1; i <= x/i; i++) {
            if ((i + 1) > x / (i + 1)) {
                return i;
            }
        }
        return 1;
    }
}
