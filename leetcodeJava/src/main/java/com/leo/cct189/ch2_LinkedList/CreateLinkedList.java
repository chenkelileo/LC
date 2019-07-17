package com.leo.cct189.ch2_LinkedList;

public class CreateLinkedList {
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
        //node6.next = null;// same

        //print all nodes
        //two methods
//        ListNode current = head;
//        while(current.next != null){
//            System.out.println(current.val);
//            current = current.next;
//        }
//
//        System.out.println(current.val);

//        ListNode current = head;
//        System.out.println(current.val);
//        while(current.next != null){
//            current = current.next;
//            System.out.println(current.val);
//        }

       // System.out.println(current.val);


        //method3
        ListNode newHead = new ListNode(1);
        newHead.endAppend(2);
        newHead.endAppend(3);
    }

}
