/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * LeetCode com.leetcode.MyStackTest
 *
 * @author Andrew Liu
 * @since 2015 19/07/2015 5:38 PM
 */
package com.leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Andrew
 */
public class MyStackTest {

    MyStack stack;

    @BeforeClass
    public void init() {
        stack = new MyStack();
    }

    @Test
    public void testMyStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(stack.empty(), false);
        Assert.assertEquals(stack.top(), 3);
        stack.pop();
        Assert.assertEquals(stack.top(), 2);
        stack.pop();
        Assert.assertEquals(stack.top(), 1);
        stack.pop();
        Assert.assertEquals(stack.empty(), true);
    }
}
