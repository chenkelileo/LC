/**
 * Implement a function to check if a linked list is a palindrome.
 * Hints:#5, #13, #29, #61, #101
 */
package com.leo.cct189.ch2_LinkedList;

//1. reverse and compare
// assume single linked list and clone

public class Palindrome_2_6 {
// clone
    public static ListNode reverseItr(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode n = new ListNode(cur.val); //clone
            n.next = pre;
            pre = n;
            cur = cur.next;
        }
        return pre;
    }
    //t:O(n)
    //s:O(n)


    public static boolean isPalindrome(ListNode node) {
        if (node == null)
            return false; //assume this scenario

        ListNode rnode = reverseItr(node);

        while (node != null) {
            if (rnode.val != node.val)
                return false;
            node = node.next;
            rnode = rnode.next;
        }
        return true;
    }

    public static ListNode reverseItrInplace(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next; //keep in mind
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseItr3(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode pre = null;
//        ListNode cur = node; //need change the node

        while (node != null) {
            ListNode next= node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static boolean isPalindrome2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        fast = head; //need to

        slow = reverseItrInplace(slow); // check with not inplace one and debug

        while(slow != null){
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    //t: O(n^2)
    //s: O(n)

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.endAppend(2);
        head.endAppend(3);
        head.endAppend(39);
        head.endAppend(2);
        head.endAppend(1);
        System.out.println(isPalindrome2(head));

    }
}
