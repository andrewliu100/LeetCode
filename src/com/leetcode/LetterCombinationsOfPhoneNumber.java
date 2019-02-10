package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfPhoneNumber {

    private static Map<String, List<Character>> phone = new HashMap<String, List<Character>>(){
        {
            put("2", Arrays.asList('a', 'b', 'c'));
            put("3", Arrays.asList('d', 'e', 'f'));
            put("4", Arrays.asList('g', 'h', 'i'));
            put("5", Arrays.asList('j', 'k', 'l'));
            put("6", Arrays.asList('m', 'n', 'o'));
            put("7", Arrays.asList('p', 'q', 'r', 's'));
            put("8", Arrays.asList('t', 'u', 'v'));
            put("9", Arrays.asList('w', 'x', 'y', 'z'));
        }
    };

    private List<String> output = new ArrayList<>();

    /**
     * O(3^n * 4^m)
     * n is the number of digits that maps to three letters
     * m is the number of digits that maps to four letters
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return output;
        }
        helper("", digits);
        return output;
    }

    private void helper(String combination, String digits) {
        if (digits.length() == 0) {
            output.add(combination);
            return;
        }

        String d = digits.substring(0, 1);
        List<Character> letters = phone.get(d);
        for (char letter : letters) {
            helper(combination + letter, digits.substring(1));
        }
    }
}
