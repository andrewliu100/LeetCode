package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 12. Integer to Roman
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        Map<Integer, String> dict = new HashMap<>();
        dict.put(1, "I");
        dict.put(4, "IV");
        dict.put(5, "V");
        dict.put(9, "IX");
        dict.put(10, "X");
        dict.put(40, "XL");
        dict.put(50, "L");
        dict.put(90, "XC");
        dict.put(100, "C");
        dict.put(400, "CD");
        dict.put(500, "D");
        dict.put(900, "CM");
        dict.put(1000, "M");

        List<Integer> bases = new ArrayList<>();
        bases.add(1000);
        bases.add(900);
        bases.add(500);
        bases.add(400);
        bases.add(100);
        bases.add(90);
        bases.add(50);
        bases.add(40);
        bases.add(10);
        bases.add(9);
        bases.add(5);
        bases.add(4);
        bases.add(1);

        int n = num;
        String roman = "";
        for (int i = 0; i < bases.size(); i++) {
            int base = bases.get(i);
            int div = n / base;
            String rm = dict.getOrDefault(div * base, "");
            if (rm.length() == 0) {
                String romanDigit = dict.get(base);
                for (int j = 1; j <= div; j++) {
                    rm += romanDigit;
                }
            }
            roman += rm;
            n = n % base;
        }
        return roman;
    }
}
