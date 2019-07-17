package com.leo.cct189.ch2_LinkedList;

public class RemoveNode_2_0 {
    public static ListNode removeNode(ListNode head, int val) {
        ListNode current = head;
        if (current.val == val)
            return head.next;
        while (current.next != null) {// need find pattern for node != null or node.next != null
            if (current.next.val == val) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.endAppend(2);
        head.endAppend(3);
        head.endAppend(3);
        head.endAppend(4);
        head.endAppend(5);

        removeNode(head, 3);


    }
}
