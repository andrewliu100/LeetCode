/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * LeetCode com.leetcode.InvertBinaryTreeTest
 *
 * @author Andrew Liu
 * @since 2015 19/07/2015 3:31 PM
 */
package com.leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Andrew
 */
public class InvertBinaryTreeTest {

    private InvertBinaryTree invertBinaryTree;

    @BeforeClass
    public void init() {
        invertBinaryTree = new InvertBinaryTree();
    }

    @DataProvider(name = "testData")
    public static Object[][] testData() {
        /**
         *         4
         *        / \
         *       2   7
         *     / \  / \
         *    1  3 6  9
         */
        Integer[] tree1 = {4, 2, 7, 1, 3, 6, 9};
        /**
         *         4
         *        / \
         *      7    2
         *     / \  / \
         *    9  6 3  1
         */
        Integer[] inverted1 = {4, 7, 9, 6, 2, 3, 1}; // pre order traversal of the inverted tree

        return new Object[][] {
                {tree1, inverted1}
        };
    }

    @Test(dataProvider = "testData")
    public void testInvertBinaryTree(Integer[] tree, Integer[] inverted) {
        InvertBinaryTree.TreeNode root = invertBinaryTree.createBinaryTree(tree);
        invertBinaryTree.invertTree(root);
        Assert.assertEquals(invertBinaryTree.toPreOrderArray(root), inverted);
    }
}
