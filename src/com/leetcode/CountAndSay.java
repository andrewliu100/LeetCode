package com.leetcode;

/**
 * 1. "1"
 * 2. "11"
 * 3. "21"
 * 4. "1211"
 * 5. "111221"
 *
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return count(countAndSay(n - 1));
    }

    private String count(String str) {
        StringBuilder sb = new StringBuilder();
        int d = str.charAt(0) - '0';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (d == str.charAt(i) - '0') {
                count++;
            } else {
                sb.append(count + "" + d);
                d = str.charAt(i) - '0';
                count = 1;
            }
        }
        sb.append(count + "" + d);
        return sb.toString();
    }
}
