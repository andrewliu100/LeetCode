package com.leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared
 * at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input
 * array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being
 * 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being
 * modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * brute force.
     *
     * Time complexity: O(n^2).
     * Worst case ([1,1,1,...,1]) the shift() is the major operation and is executed n - 2 times,
     * shift() itself takes O(n), thus the time complexity is O(n^2)
     *
     * Space complexity: O(1).
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int count = 0;
        int curNum = nums[0];
        while (i < nums.length) {
            if (nums[i] < curNum) {
                return i;
            }

            if (curNum == nums[i]) {
                count++;
            } else { // curNum > nums[i]
                curNum = nums[i];
                count = 1;
            }

            if (count <= 2) {
                i++;
            } else if (count < nums.length - i + 2) { // case [1,2,2,2,2,2]
                shift(nums, i);
            } else {
                return i;
            }
        }
        return i;
    }

    private void shift(int[] nums, int i) {
        int tmp = nums[i];
        for (; i + 1 < nums.length; i++) {
            nums[i] = nums[i + 1];
        }
        nums[i] = tmp;
    }

    /**
     * Two pointers.
     *
     * Can be generalized to any remove duplicates from sorted array with allowed number
     * of duplicated k.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int removeDuplicates2(int[] nums) {
        // allowed number of duplicates
        int k = 2;
        if (nums.length <= k) {
            return nums.length;
        }

        int cnt = 1;
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[len] = nums[i];
                cnt = 1;
                len++;
            } else {
                if (cnt < k) {
                    nums[len] = nums[i];
                    cnt++;
                    len++;
                }
            }
        }
        return len;
    }
}
