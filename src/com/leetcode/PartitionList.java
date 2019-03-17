package com.leetcode;

import com.leetcode.model.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two
 * partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {

    /**
     * dummy node + 3 pointers
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Point to the previous node of the first node greater than or equal to x
        ListNode pre1 = dummy;
        // Point to the previous node of the current node
        ListNode pre2 = dummy;
        // Pointer travese the list
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                if (pre1 == pre2) { // didn't see a node greater than or equal to x yet
                    pre2 = pre2.next;
                    cur = cur.next;
                } else {
                    // re-organise the list
                    pre2.next = cur.next;
                    cur.next = pre1.next;
                    pre1.next = cur;

                    // move cur to the right position
                    cur = pre2.next;
                }
                pre1 = pre1.next;
            } else {
                pre2 = pre2.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
