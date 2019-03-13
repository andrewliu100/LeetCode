package com.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 *
 *  - This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 *  - Would this affect the run-time complexity? How and why?
 *
 */
public class SearchRotatedSortedArrayII {

    /**
     * Binary search.
     *
     * Time complexity: O(logn)
     * Space complexity: O(1)
     *
     */
    public boolean exist(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[lo] < nums[mid] || nums[hi] < nums[mid]) {
                // we are sure left side is sorted end at mid, e.g. [2,2,5,6,0,0,1] and mid = 3
                // NEED TO CHECK nums[hi] < nums[mid] for special cases like [2,2,2,2,0,0,1]
                if (target < nums[mid] && target >= nums[lo]) {
                    // target must be in left side
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

            } else if (nums[mid] < nums[hi] || nums[mid] < nums[lo]) {
                // we are sure right side is sorted start from mid, e.g. [2,5,6,0,0,1,2] and mid =3
                // NEED TO CHECK nums[mid] < nums[lo] for special cases like [3,4,2,2,2,2,2]
                if (target > nums[mid] && target <= nums[hi]) {
                    // target must be in right side
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                // when we reach here, nums[lo] == nums[mid] == nums[hi].
                // we can safely skip nums[lo] and nums[hi] as they mustn't equal to target
                lo++;
                hi--;
            }

        }
        return false;
    }
}
