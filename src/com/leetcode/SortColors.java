package com.leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 */
public class SortColors {

    /**
     * Two passes.
     *
     * Time complexity: O(n). n is the length of the nums
     * Space complexity: O(1).
     *
     */
    public void sortColors1(int[] nums) {
        // array of size 3, the counts of 0,1 and 2 stored in the index 0, 1 and 2 respectively
        int[] counts = new int[3];

        // first pass to get the counts
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]] += 1;
        }

        // second pass reconstruct the array
        for (int i = 0; i < counts[0]; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < counts[1]; i++) {
            nums[i + counts[0]] = 1;
        }
        for (int i = 0; i < counts[2]; i++) {
            nums[i + counts[0] + counts[1]] = 2;
        }
    }

    /**
     * One pass. Three pointers.
     *
     * Time complexity: O(n). n is the length of the nums
     * Space complexity: O(1).
     */
    public void sortColors2(int[] nums) {
        int i = 0; // moving pointer, find 0s and 2s
        int p1 = 0; // pointer to 1s
        int p2 = nums.length - 1; // pointer to known end

        while (i <= p2) {
            if (nums[i] == 0) {
                // swap 0 to front
                swap(nums, i, p1);
                p1++;
                i++;
            } else if (nums[i] == 2) {
                // swap 2 to end
                swap(nums, i, p2);
                p2--;
            } else { // nums[i] == 1
                // don't move 1
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
