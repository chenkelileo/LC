package com.leo.cct189.ch2_LinkedList;

public class Reverse {

    //will clone and create new linkedlist
    //create the array, that will be the same
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode n = new ListNode(cur.val);
            n.next = pre;
            pre = n;
            cur = cur.next;

            //ListNode next = cur.next;
            //cur.next = pre;
            //pre = cur;
            //cur = next;
        }

        return pre;
    }
    //t: O(n)
    //s: O(n)


    //in-place, suggested and keep in mind
    public static ListNode reverseLinkedList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
//            ListNode n = new ListNode(cur.val);
//            n.next = pre;
//            pre = n;
//            cur = cur.next;

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    //t: O(n)
    //s: O(1)


    //different format, change the position of the head
    public static void reverseLinkedList3(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
//            ListNode n = new ListNode(cur.val);
//            n.next = pre;
//            pre = n;
//            cur = cur.next;

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
    }

    //dummy insert at dummy every time
    public static ListNode reverseLinkedList4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    //what is the space competity O(1) I think

    //not necessary
    public static ListNode reverseLinkedList5(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            p1.next = p2.next;
            p2.next = prev.next;
            prev.next = p2;
            p2 = p1.next;
        }
        return dummy.next;
    }


//    public static ListNode reverseLinkedList6(ListNode head) {
//        if (head == null || head.next == null) return head;
//        // 逆置后的头结点
//        ListNode reversedHead = null;
//        ListNode prev = null;
//        // 当前头结点
//        ListNode cur = head;
//        while (cur != null) {
//            // 保存后继
//            ListNode next = cur.next;
//
//            // next为null的节点为尾节点（翻转后的头结点一定是原始链表的尾结点）
//            if (next == null) reversedHead = cur;
//
//            // 逆转的过程，并且能将头结点的 prev 置为 NULL
//            cur.next = prev;
//
//            // 指针往后移
//            prev = cur; // 前继结点到现任节点，勿忘断链的情形，需要使用 pre 指针保存状态，pre 等价于是后移一个结点
//            cur = next; // 现任节点到下一结点，cur 后移一个结点
//        }
//        return reversedHead;
//    }


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
        //ListNode headCopy = new ListNode(1);

        reverseLinkedList5(head);

    }
}
