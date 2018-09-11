package com.leetcode.model;

public class BinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

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
    public static TreeNode createBinaryTree(Integer[] array) {
        if (array.length < 1) {
            return null;
        }
        return load(new TreeNode(array[0]), array, 0);
    }

    private static TreeNode load(TreeNode node, Integer[] values, int index) {
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
}
