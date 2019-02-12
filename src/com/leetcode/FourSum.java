package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    private List<List<Integer>> res = new ArrayList<>();

    /**
     * O(n^3). n is the number of integers in nums.
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            threeSum(nums, i, target - nums[i]);
        }
        return res;
    }

    private void threeSum(int[] nums, int idx, int tar) {
        for (int i = idx + 1; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == tar) {
                    res.add(Arrays.asList(nums[idx], nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < tar) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }
}
