/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * LeetCode com.leetcode.InvertBinaryTree
 *
 * @author Andrew Liu
 * @since 2015 12/07/2015 5:04 AM
 */
package com.leetcode;

import com.leetcode.model.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew
 */
public class InvertBinaryTree {


    public BinaryTree.TreeNode invertTree(BinaryTree.TreeNode root) {
        if (root != null) {
            BinaryTree.TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
        return null;
    }

    List<Integer> tempList = new ArrayList<Integer>();

    private void traverse(BinaryTree.TreeNode node) {
        if (node != null) {
            tempList.add(node.val);
            traverse(node.left);
            traverse(node.right);
        }
    }

    public Integer[] toPreOrderArray(BinaryTree.TreeNode root) {
        traverse(root);
        return (Integer[])tempList.toArray(new Integer[tempList.size()]);
    }

}
