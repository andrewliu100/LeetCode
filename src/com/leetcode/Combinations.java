package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Combinations {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    private int k;

    /**
     * Back tracking.
     *
     * Time complexity: O(n!/(n-k)!)
     */
    public List<List<Integer>> combine(int n, int k) {
        nums = new int[n];
        this.k = k;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        helper(new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<Integer> data, int idx) {
        if (data.size() == k) {
            res.add(new ArrayList<>(data));
        } else {
            for (int i = idx; i < nums.length; i++) {
                data.add(nums[i]);
                helper(data, i + 1);
                data.remove(data.size() - 1);
            }
        }
    }
}
