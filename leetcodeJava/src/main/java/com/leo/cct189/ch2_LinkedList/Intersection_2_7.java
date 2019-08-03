/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the inter­ secting node. Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 * Hints:#20, #45, #55, #65, #76, #93, #111, #120, #129
 */
package com.leo.cct189.ch2_LinkedList;

// assume
// get the length first, if last node is not the exact the same, then return null;
// for the longer list, start from the difference position
// find the first exactly the same
public class Intersection_2_7 {
    public static ListNode returnFirstIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode cur1 = headA;
        ListNode cur2 = headB;

        int len1 = 1;
        int len2 = 1;

        while (cur1.next != null) {
            len1++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            len2++;
            cur2 = cur2.next;
        }

        if (cur1 != cur2)
            return null;

        if (len1 > len2) {// make len2 is longer than len1
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        cur1 = headA;
        cur2 = headB;

        for (int i = 0; i < Math.abs(len2 - len1); i++) {
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            if (cur1 == cur2)
                return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }

    //t:O(a+b)
    //s:O(1)

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int length(ListNode node) {//wont' change head, only for reference
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else {
                curA = curA.next;
            }

            if (curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }

        }

        return curA;
    }


    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode nodeA2 = new ListNode(9);
        ListNode nodeA3 = new ListNode(1);
        ListNode nodeA4 = new ListNode(2);
        ListNode nodeA5 = new ListNode(4);

        headA.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;

        ListNode headB = new ListNode(3);

        headB.next = nodeA4;

        //returnFirstIntersectionNode(headA, headB);
        getIntersectionNode(headA, headB);
    }

}
