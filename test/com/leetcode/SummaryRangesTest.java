/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 *
 * LeetCode com.leetcode.SummaryRangesTest.java
 *
 * @author Andrew Liu
 * @since 2015 27/06/2015 3:11:42 pm 
 */
package com.leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Andrew
 *
 */
public class SummaryRangesTest {
	
	private SummaryRanges summaryRanges;
	
	@BeforeMethod
	public void init() {
		summaryRanges = new SummaryRanges();
	}
	
	@DataProvider(name = "numbers")
	public static Object[][] sortedArrays() {
		return new Object[][] {
				{new int[]{0}, new String[]{"0"}},
				{new int[]{0, 1, 2}, new String[]{"0->2"}},
				{new int[]{0, 1, 2, 4, 5, 7}, new String[]{"0->2", "4->5", "7"}}
		};
	}
	
	@Test(dataProvider = "numbers")
	public void testSummaryRanges(int[] numbers, String[] ranges) {
		Assert.assertEquals(summaryRanges.summaryRanges(numbers).toArray(), ranges);
	}

}
