package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *   - All numbers (including target) will be positive integers.
 *   - The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();

    /**
     * Backtracking. O(n!)? n is the number of integers in candidates
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, 0, target);
        return res;
    }

    private void helper(int[] nums, int idx, int target) {
        int sum = sumUp();
        if (sum < target) {
            for (int i = idx; i < nums.length; i++) {
                combination.add(nums[i]);
                helper(nums, i, target);
            }
        }
        if (sum == target) {
            res.add(new ArrayList<>(combination));
        }
        if (combination.size() > 0)
            combination.remove(combination.size() - 1);
    }

    private int sumUp() {
        int sum = 0;
        for (int i : combination) {
            sum += i;
        }
        return sum;
    }
}
