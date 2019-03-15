package com.leetcode;

import com.leetcode.model.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {

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
                    pre.next = cur.next;
                } else {
                    pre = pre.next;
                }
                cnt = 1;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
