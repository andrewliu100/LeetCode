package com.leetcode;

import com.leetcode.model.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    /**
     * Time complexity: O(n). n is the total number of node in the list
     * Space complexity: O(1).
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // Make a ring
        ListNode oldTail = head;
        int n = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            n++;
        }
        oldTail.next = head;

        // Find the new tail
        ListNode newTail = head;
        for (int i = 1; i < n - k % n; i++) {
            newTail = newTail.next;
        }

        // Get the new head and make the new list
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
