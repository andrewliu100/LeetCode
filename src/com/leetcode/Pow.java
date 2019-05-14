package com.leetcode;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *   -- -100.0 < x < 100.0
 *   -- n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */
public class Pow {

    /**
     * O(logn)
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n < 0) {
            // Will be stack overflow when n = -2^31 because -n doesn't become positive,
            // so we do -(n + 1)
            return 1/x * 1.0/myPow(x, -(n + 1));
        } else {
            // n > 0
            double res = x;
            double oddMultiply = 1.0;
            while (n > 1) {
                res *= res;
                if (n % 2 == 1) {
                    oddMultiply *= x;
                }
                n = n/2;
            }
            return res * oddMultiply;
        }
    }

    /**
     * O(logn). Using bit operation (From EPI)
     */
    public double power(double x, int n) {
        double result = 1.0;
        if (n < 0) {
            x = 1/x;
            n = -n; // No need to worry about stack overflow when n = -2^31
        }
        while (n != 0) {
            if ((n & 1) != 0) {
                result *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return result;
    }
}
