package com.leetcode;

import com.leetcode.model.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {


    public int countNodes(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesLevelFirstTraverse(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        int count = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree.TreeNode node = queue.poll();
            if (node.left != null) {
                count++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                count++;
                queue.offer(node.right);
            }
        }
        return count;
    }
}
