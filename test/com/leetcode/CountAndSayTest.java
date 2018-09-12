package com.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CountAndSayTest {

    private CountAndSay countAndSay = new CountAndSay();

    @Test
    public void testCountAndSay() {
        Assert.assertEquals(countAndSay.countAndSay(1), "1");
        Assert.assertEquals(countAndSay.countAndSay(2), "11");
        Assert.assertEquals(countAndSay.countAndSay(3), "21");
        Assert.assertEquals(countAndSay.countAndSay(4), "1211");
        Assert.assertEquals(countAndSay.countAndSay(5), "111221");
        Assert.assertEquals(countAndSay.countAndSay(6), "312211");
    }

}
