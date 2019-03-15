package com.leetcode;

import com.leetcode.model.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * dummy, pre, cur
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        int cnt = 1;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cnt++;
            } else {
                if (cnt > 1) {
                    pre.next = cur;
                }
                pre = pre.next;
                cnt = 1;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
