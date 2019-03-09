package com.epi.primarytypes.bits;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BitCountTest {

    private BitCount instance;

    @BeforeMethod
    public void init() {
        instance = new BitCount();
    }

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][] {
                {8, (short)1},
                {10, (short)2},
                {15, (short)4},
                {Integer.MAX_VALUE, (short)31}
        };
    }

    @Test(dataProvider = "data")
    public void test(int x, short count) {
        Assert.assertEquals(instance.bruteForce(x), count);
        Assert.assertEquals(instance.improvedBruteForce(x), count);
    }
}
