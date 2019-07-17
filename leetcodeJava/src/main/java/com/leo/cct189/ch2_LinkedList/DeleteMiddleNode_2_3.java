/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
 * EXAMPLE
 * lnput:the node c from the linked lista->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks likea->b->d->e- >f
 */

package com.leo.cct189.ch2_LinkedList;

public class DeleteMiddleNode_2_3 {

    public static boolean deleteMiddleNode(ListNode node) {
        if (node == null || node.next == null)//not the last node
            return false;

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;

        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        deleteMiddleNode(node2);

    }
}
