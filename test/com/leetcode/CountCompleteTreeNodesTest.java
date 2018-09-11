package com.leetcode;

import com.leetcode.model.BinaryTree;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CountCompleteTreeNodesTest {

    private CountCompleteTreeNodes instance;

    @BeforeClass
    public void before() {
        instance = new CountCompleteTreeNodes();
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
        Integer count1 = 7; // nodes count of the tree

        /**
         *         4
         *        / \
         *       2   7
         *     / \  /
         *    1  3 6
         */
        Integer[] tree2 = {4, 2, 7, 1, 3, 6};
        Integer count2 = 6; // nodes count of the tree

        return new Object[][] {
            {tree1, count1},
            {tree2, count2}
        };
    }

    @Test(dataProvider = "testData")
    public void testCountCompleteTreeNodes(Integer[] tree, Integer count) {
        BinaryTree.TreeNode root = BinaryTree.createBinaryTree(tree);
        Assert.assertEquals(instance.countNodes(root), count.intValue());
        Assert.assertEquals(instance.countNodesLevelFirstTraverse(root), count.intValue());
    }

}
