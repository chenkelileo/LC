package com.leo.cct189.ch2_LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    void endAppend(int data) {
        ListNode end = new ListNode(data);
        ListNode current = this;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
    }
}
