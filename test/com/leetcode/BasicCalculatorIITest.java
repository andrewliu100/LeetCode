/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * LeetCode com.leetcode.BasicCalculatorIITest
 *
 * @author Andrew Liu
 * @since 2015 11/07/2015 9:26 PM
 */
package com.leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Andrew
 */
public class BasicCalculatorIITest {

    private BasicCalculatorII calculator;

    @BeforeClass
    public void init() {
        calculator = new BasicCalculatorII();
    }

    @DataProvider(name = "input")
    public static Object[][] input() {
        return new Object[][] {
                {"3+2*2", 7},
                {" 3/2 ", 1},
                {" 3+5 / 2 ", 5},
                {"   1 + 2 - 3 *    5 / 3 /3 + 9/3*2  + 5", 13},
                {"1*2-3/4+5*6-7*8+9/10", -24}
        };
    }

    @Test(dataProvider = "input")
    public void testCalculate(String input, int result) {
        Assert.assertEquals(calculator.calculate(input), result);
    }
}
