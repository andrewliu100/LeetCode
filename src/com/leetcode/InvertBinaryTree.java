/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * LeetCode com.leetcode.InvertBinaryTree
 *
 * @author Andrew Liu
 * @since 2015 12/07/2015 5:04 AM
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew
 */
public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Create a binary tree from the given array.
     * eg,{4, 2, 7, 1, 3, 6, 9} is converted to the tree below.
     *         4
     *        / \
     *       2   7
     *     / \  / \
     *    1  3 6  9
     * @param array An array represented tree
     * @return The root of the tree
     */
    public TreeNode createBinaryTree(Integer[] array) {
        if (array.length < 1) {
            return null;
        }
        return load(new TreeNode(array[0]), array, 0);
    }

    private TreeNode load(TreeNode node, Integer[] values, int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (leftIndex < values.length) {
            node.left = load(new TreeNode(values[leftIndex]), values, leftIndex);
        }
        if (rightIndex < values.length) {
            node.right = load(new TreeNode(values[rightIndex]), values, rightIndex);
        }
        return node;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
        return null;
    }

    List<Integer> tempList = new ArrayList<Integer>();

    private void traverse(TreeNode node) {
        if (node != null) {
            tempList.add(node.val);
            traverse(node.left);
            traverse(node.right);
        }
    }

    public Integer[] toPreOrderArray(TreeNode root) {
        traverse(root);
        return (Integer[])tempList.toArray(new Integer[tempList.size()]);
    }

}
