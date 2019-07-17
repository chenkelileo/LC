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

public class SumLists_2_5 {
    public static ListNode sumLists(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0);
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode cur = dum;
        int sum = 0;

        while(current1 != null || current2 != null ){
            if(current1 != null){
                sum += current1.val;
                current1 = current1.next;
            }
            if(current2 != null){
                sum += current2.val;
                current2 = current2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }

        if(sum == 1)
            cur.next = new ListNode(1);

        return dum.next;

    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(7);
        list1.endAppend(1);
        list1.endAppend(6);

        ListNode list2 = new ListNode(4);
        sumLists(list1,list2);

    }
}
