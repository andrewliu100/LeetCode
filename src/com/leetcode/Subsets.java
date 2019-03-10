package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Subsets {

    private List<List<Integer>> res = new ArrayList<>();

    /**
     * Time complexity: O(C(n,0) + C(n,1) + ... + C(n, n-1) + C(n, n)). C(n, k) = n!/(n-k)!
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return res;
        }

        for (int k = 0; k < nums.length; k++) {
            combine(nums, new ArrayList<>(), 0, k);
        }
        return res;
    }

    private void combine(int[] nums, List<Integer> data, int from, int k) {
        if (data.size() == k) {
            res.add(new ArrayList<>(data));
        } else {
            for (int i = from; i < nums.length; i++) {
                data.add(nums[i]);
                combine(nums, data, i + 1, k);
                data.remove(data.size() - 1);
            }
        }
    }
}
