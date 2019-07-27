/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains
 * a single digit.The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295. Output:2 -> 1 -> 9.Thatis,912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
 * lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output:9 -> 1 -> 2.Thatis,912.
 * Hints: #7, #30, #71, #95, #109
 * <p>
 * 617 + 395 =1012  2 -> 1 -> 0 ->1
 * 7+5 = 2  1
 * 1+9 = 0  0 + 1 = 1
 * <p>
 * 7->1->6 +4
 * 617 + 4
 * <p>
 * 621
 * <p>
 * 9->1->6
 */
package com.leo.cct189.ch2_LinkedList;

import java.util.Stack;

public class SumLists_2_5 {
    public static ListNode sumLists(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0);
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode cur = dum;
        int sum = 0;

        while (current1 != null || current2 != null) {
            if (current1 != null) {
                sum += current1.val;
                current1 = current1.next;
            }
            if (current2 != null) {
                sum += current2.val;
                current2 = current2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }

        if (sum == 1)
            cur.next = new ListNode(1);

        return dum.next;
    }

    //t: O(n)
    //s: O(n)


    public static ListNode sumListsFollowup(ListNode list1, ListNode list2) {
        ListNode reverseList1 = Reverse.reverseLinkedList2(list1);
        ListNode reverseList2 = Reverse.reverseLinkedList2(list2);
        return Reverse.reverseLinkedList2(sumLists(reverseList1, reverseList2));
    }
    //t:O(n)
    //s:O(n)

    public static ListNode sumListsFollowup2(ListNode list1, ListNode list2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int sum = 0;

        while (list1 != null) {
            s1.push(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            s2.push(list2.val);
            list2 = list2.next;
        }

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            s3.push(sum % 10);
            sum /= 10;
        }
        if (sum == 1)
            s3.push(1);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!s3.isEmpty()) {
            cur.next = new ListNode(s3.pop());
            cur = cur.next;

        }
        return dummy.next;
    }

    public static ListNode sumListsFollowup3(ListNode list1, ListNode list2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        //Stack<Integer> s3 = new Stack<>();
        int sum = 0;

        while (list1 != null) {
            s1.push(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            s2.push(list2.val);
            list2 = list2.next;
        }

        ListNode dummy = new ListNode(0); //can't use curr, cause no real linkedlist here.

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            sum /= 10;
            ListNode node = new ListNode(sum);
            node.next = dummy;
            dummy = node; // check it loop

//            ListNode next = cur.next;
//            cur.next = dummy.next;
//            dummy.next = cur;
//            cur = next;
//            s3.push(sum % 10);
            //sum /= 10; //can put at the top
        }

        if (sum == 1) {
            ListNode node = new ListNode(1);
            node.next = dummy;
            dummy = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(7);
        list1.endAppend(1);
        list1.endAppend(6);

        ListNode list2 = new ListNode(4);

        sumLists(list1, list2);

        ListNode list3 = new ListNode(6);
        list3.endAppend(1);
        list3.endAppend(7);

        ListNode list4 = new ListNode(2);
        list4.endAppend(9);
        list4.endAppend(5);
        ListNode list5 = sumListsFollowup3(list3, list4);

    }
}
