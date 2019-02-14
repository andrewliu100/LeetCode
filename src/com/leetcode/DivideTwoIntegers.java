package com.leetcode;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *    * Both dividend and divisor will be 32-bit signed integers.
 *    * The divisor will never be 0.
 *    * Assume we are dealing with an environment which could only store integers within the 32-bit
 *      signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your
 *      function returns 2^31 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {

    /**
     * O(logn). n is the division = dividend / divisor.
     */
    public int divide(int dividend, int divisor) {
        // Overflow case: -2^31 / -1 = 2^31. Should return 2^31 - 1 as required
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Decide the sign
        int sign = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? 1 : -1;

        // Unify the sign to negative of dividend and divisor.
        // Not using abs value is because of overflow of -2^31.
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        int division = helper(a, b);
        return sign > 0 ? division : -division;
    }

    private int helper(int a, int b) {
        if (a > b) {
            // example case a = -3, b = -5. a/b = 0
            return 0;
        }
        int res = 0;
        int sum = b;
        int preSum = sum;
        while (sum <= a) {
            preSum = sum;
            sum = sum << 1;
            res = res == 0 ? 1 : res << 1;
            if (sum > 0)
                // Overflow if sum is accumulated to -2^31
                break;
        }
        return res + helper(a - preSum, b);
    }
}
