package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 *  -All numbers (including target) will be positive integers.
 *  -The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {

    private Set<List<Integer>> res = new HashSet<>();
    private List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target);
        return new ArrayList<>(res);
    }

    void helper(int[] sortedNums, int idx, int target) {
        int sum = sumUp();
        if (sum < target) {
            for (int i = idx; i < sortedNums.length; i++) {
                combination.add(sortedNums[i]);
                helper(sortedNums, i + 1, target);
            }
        }
        if (sum == target) {
            res.add(combination);
        }

        if (combination.size() > 0) {
            combination.remove(combination.size() - 1);
        }
    }

    private int sumUp() {
        int sum = 0;
        for (int i : combination) {
            sum += i;
        }
        return sum;
    }
}

