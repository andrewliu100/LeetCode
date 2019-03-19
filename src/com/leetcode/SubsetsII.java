package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {

    Set<List<Integer>> res = new HashSet<>();

    /**
     * Backtracking
     *
     * Time complexity: O(C(n,0) + C(n,1) + ... + C(n, n-1) + C(n, n)). C(n, k) = n!/(n-k)!
     * Space complexity: O(?)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            combination(nums, i);
        }
        return new ArrayList<>(res);
    }

    private void combination(int[] nums, int k) {
        List<Integer> comb = new ArrayList<>();
        combin(comb, nums, 0, k);
    }

    private void combin(List<Integer> comb, int[] nums, int idx, int k) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            comb.add(nums[i]);
            combin(comb, nums, i + 1, k);
            comb.remove(comb.size() - 1);
        }
    }
}
