package com.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class UniquePathsTest {

    private UniquePaths uniquePaths;

    @BeforeMethod
    public void init() {
        uniquePaths = new UniquePaths();
    }

    @Test
    public void testUniquePaths() {
        BigInteger res = uniquePaths.uniquePaths2(100, 100);
        System.out.println(res);
    }
}
