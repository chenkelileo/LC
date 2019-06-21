package com.leo.leetcode.lc0206;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class lc206ReverseLinkedList {
    public ListNode reverseList(ListNode head) { //head means cur head
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;//move pre first, since head.next = pre
            head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return helper(head, null);
    }

    public ListNode helper(ListNode cur, ListNode pre) {
        if (cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return helper(next, cur);
    }

    public static void main(String[] args) {

    }
}
