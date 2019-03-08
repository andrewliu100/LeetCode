package com.leetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position
 * of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindRangeOfElementInSortedArray {

    /**
     * O(logn) n is the number of elements in nums
     */
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (nums.length > 0) {
            int left = findIdx(nums, target, true);
            // Important to check if left is found as findIdx will always return
            // an index even target is not found;
            if (left > -1 && left < nums.length && nums[left] == target) {
                range[0] = left;
                range[1] = findIdx(nums, target, false);
            }
        }
        return range;
    }

    private int findIdx(int[] nums, int target, boolean leftBound) {
        int lo = 0;
        // Not using "nums.length - 1" for cases when right bound is "nums.length - 1"
        // e.g. [1,2,2,2,2] target = 2, we return lo - 1 when search right bound.
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // Normal binary search when target != nums[mid]
            if (target < nums[mid]) {
                // Not using "mid - 1" due to we return lo - 1 when search right bound.
                // e.g. [5,7,7,8,8,10] target = 8, if using "mid - 1" right bound will be 3 instead of 4.
                hi = mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
               // target == nums[mid]
               // Instead of return in normal binary search, we continue to search bounds
                if (leftBound) {
                    hi = mid;
                } else {
                    // Not using "mid" because mid == lo in even number of array
                    lo = mid + 1;
                }
            }
        }
        return leftBound? lo : lo - 1;
    }
}
