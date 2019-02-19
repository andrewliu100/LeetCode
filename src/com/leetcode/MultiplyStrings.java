package com.leetcode;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class MultiplyStrings {

    /**
     * O(m * n). m is the number of digits in num1, n is the number of digits in num2.
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] base = new int[m + n];
        int[] carry = new int[m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int raw = base[i + j] + prod % 10;
                if (carry[i + j] > 0) {
                    raw += carry[i + j];
                    carry[i + j] = 0;
                }
                base[i + j] = raw % 10;
                carry[i + j + 1] = carry[i + j + 1] + prod / 10 + raw / 10;
            }
        }

        boolean isLeadZero = true;
        StringBuilder sb = new StringBuilder();
        for (int i = m + n - 1; i > -1; i--) {
            int d = base[i] + carry[i];
            if (isLeadZero && d == 0) {
                continue;
            }
            isLeadZero = false;
            sb.append("" + d);
        }
        return sb.toString();
    }
}
