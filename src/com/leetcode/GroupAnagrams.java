package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *    - All inputs will be in lowercase.
 *    - The order of your output does not matter.
 */
public class GroupAnagrams {

    /**
     * O(n*k). n is the number of Strings in array, k is the length of longest String.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> countMap = new HashMap<>();
        for (String s : strs) {
            String count = count(s);
            List<String> anagram = countMap.getOrDefault(count, new ArrayList<>());
            anagram.add(s);
            countMap.put(count, anagram);
        }
        return new ArrayList<>(countMap.values());
    }

    private String count(String s) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : counts) {
            sb.append(i);
        }
        return sb.toString();
    }
}
