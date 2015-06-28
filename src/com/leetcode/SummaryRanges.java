/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 *
 * LeetCode com.leetcode.SummaryRanges.java
 *
 * @author Andrew Liu
 * @since 2015 27/06/2015 3:09:38 pm 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew
 *
 */
public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        if (nums.length == 0) {
            return ranges;
        }
        
        int counter = 0;
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            counter++;
            // A range is broken
            if (i == nums.length || nums[i] != start + counter) {
                int end = nums[i - 1];
                if (end == start) {
                    ranges.add(end + "");
                }
                else {
                    ranges.add(start + "->" + end);
                }
                if (i != nums.length) {
                	// Reset start and counter
                	start = nums[i];
                	counter = 0;
                }
            }
        }
        return ranges;
    }
}
