package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    private List<String> res = new ArrayList<>();

    /**
     * O(4^n/sqrRoot(n)). n-th Catalan number.
     */
    public List<String> generateParenthesis(int n) {
        helper("", 0, 0, n);
        return res;
    }

    private void helper(String prefix, int left, int right, int n) {
        if (left == n && right == n && isValid(prefix)) {
            res.add(prefix);
        } else {
            if (left < n) {
                helper(prefix + "(", left + 1, right, n);
            }
            if (right < n) {
                helper(prefix + ")", left, right + 1, n);
            }
        }
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else
                stack.pop();
        }
        return stack.isEmpty();
    }
}
