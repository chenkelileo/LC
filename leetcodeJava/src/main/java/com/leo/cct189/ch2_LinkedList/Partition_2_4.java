package com.leo.cct189.ch2_LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class Partition_2_4 {
    public static ListNode partition(ListNode head, int val) {
        ListNode current = head;
        ArrayList<Integer> nodesVal = new ArrayList<Integer>();
        while (current != null) {
            nodesVal.add(current.val);
            current = current.next;
        }
        Collections.sort(nodesVal);

        ListNode head2 = new ListNode(nodesVal.get(0));
        for (int i = 1; i < nodesVal.size(); i++) {
            head2.endAppend(nodesVal.get(i));
        }
        return head2;
    }

    //linkedlist is good for modify
    //1. create two half linkedlists to store smaller nodes and bigger nodes via iteration
    //2. link together
    //t: O(n)
    //s: O(n)

    public static ListNode partition2(ListNode node, int val) {
        if (node == null) {
            return null;
        }

        ListNode smallPartHead = null;
        ListNode smallPartCurrent = null;
        ListNode largePartHead = null;
        ListNode largePartCurrent = null;

        while (node != null) {
            ListNode next = node.next;
            if (node.val < val) {
                if (smallPartHead == null) {
                    smallPartHead = node;
                    smallPartCurrent = smallPartHead;
                } else {
                    smallPartCurrent.next = node;
                    smallPartCurrent = smallPartCurrent.next;// or = node
                }

            } else {
                if (largePartHead == null) {
                    largePartHead = node;
                    largePartCurrent = largePartHead;
                } else {
                    largePartCurrent.next = node;
                    largePartCurrent = largePartCurrent.next;
                }

            }
            node = next;
        }
        largePartCurrent.next = null;

        if (smallPartHead == null)
            return largePartHead;

        smallPartCurrent.next = largePartHead;
        return smallPartHead;
    }
    public static ListNode partition3(ListNode node, int x) {
        ListNode head = node;
        ListNode tail= node;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                /* Ins ert node at head. */
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next= null;
        return head;}

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(11);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        partition3(head, 5);
    }

}
