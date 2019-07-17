/**
 * R�mov� Dups! Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed? Hints: #9, #40
 */
package com.leo.cct189.ch2_LinkedList;

import java.util.HashSet;

public class RemoveDups_2_1 {
    public static void removeDups(ListNode node) {
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode current = node;
        ListNode previous = null;

        while (current != null) {
            if (!set.add(current.val))
                previous.next = current.next;
            else {
                previous = current;
            }
            current = current.next;
        }
    }

    public static void removeDups2(ListNode head) {
        ListNode current = head;
        while (current != null) {
            /* Remove all future nodes that have the same value */
            ListNode runner = current;
            while (runner.next != null) {//runner will also replace head linkedlist
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.endAppend(2);
        head.endAppend(3);
        head.endAppend(3);
        head.endAppend(4);
        head.endAppend(3);
        removeDups2(head);

    }
}
