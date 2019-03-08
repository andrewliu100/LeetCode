package com.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchRotatedSortedArray {

    /**
     * O(logn)
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // There must be a half is sorted in rotated sorted array.
            // Find the sorted half first
            // use <= instead of < for [3,1] target = 1
            if (nums[lo] <= nums[mid]) {
                // left half is sorted
                // [4,5,6,7,8,1,2,3] nums[mid] = 7
                if (target < nums[mid] && target >= nums[lo]) {
                    // must in left half
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // right half is sorted
                // [7,0,1,2,4,5,6] nums[mid]=2
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
