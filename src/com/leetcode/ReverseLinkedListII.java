package com.leetcode;

import com.leetcode.model.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 */
public class ReverseLinkedListII {

    /**
     * Dummy node, 3 pointers
     *
     * Time complexity: O(n). n is the number of nodes in the list
     * Space complexity: O(1)
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode bs = dummy;
        ListNode c = head;
        ListNode bc = dummy;
        int cnt = 1;
        while (c != null && cnt <= n) {
            if (cnt < m) {
                bs = bs.next;
                c = c.next;
                bc = bc.next;
            } else if (cnt == m) {
                c = c.next;
                bc = bc.next;
            } else if (cnt <= n) {
                bc.next = c.next;
                c.next = bs.next;
                bs.next = c;
                c = bc.next;
            }
            cnt++;
        }
        return dummy.next;
    }
}
