/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C[thesameCasearlier]
 * Output: C
 * Hints: #50, #69, #83, #90
 */
package com.leo.cct189.ch2_LinkedList;

import java.util.HashSet;

public class LoopDetection_2_8 {
    public static boolean loopDetect(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (!set.add(cur))
                return true;
            cur = cur.next;
        }

        return false;
    }

    public static ListNode loopDetect3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (!set.add(cur))
                return cur;
            cur = cur.next;
        }

        return null;
    }

    public static boolean loopDetect2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static ListNode loopDetect4(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        while (slow != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
    }
}
