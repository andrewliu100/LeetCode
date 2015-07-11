/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * LeetCode com.leetcode.BasicCalculatorII
 *
 * @author Andrew Liu
 * @since 2015 11/07/2015 9:19 PM
 */
package com.leetcode;

import java.util.Stack;

/**
 * @author Andrew
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1) {
                switch (op) {
                    case '+': {
                        stack.push(num);
                        break;
                    }
                    case '-': {
                        stack.push(-num);
                        break;
                    }
                    case '*': {
                        stack.push(stack.pop() * num);
                        break;
                    }
                    case'/': {
                        stack.push(stack.pop() / num);
                        break;
                    }
                }
                num = 0;
                op = s.charAt(i);
            }
        }
        int result = 0;
        while (!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }
}
