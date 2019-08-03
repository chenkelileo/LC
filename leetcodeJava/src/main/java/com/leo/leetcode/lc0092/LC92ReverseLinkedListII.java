/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
package com.leo.leetcode.lc0092;

import com.leo.leetcode.ListNode;

public class LC92ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || (m == 1 && n == 1))
            return head;

        ListNode dummy = new ListNode(0); // for new list;
        dummy.next = head;

        ListNode cur1 = dummy;
        ListNode pre1 = null;

        for (int i = 0; i < m; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        for (int i = m; i <= n; i++) {
            ListNode next = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = next;
        }

        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        reverseBetween(head, 3, 5);
    }
}
