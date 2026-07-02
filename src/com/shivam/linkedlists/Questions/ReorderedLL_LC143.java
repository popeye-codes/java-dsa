package com.shivam.linkedlists.Questions;



public class ReorderedLL_LC143 {

    private ListNode head;
    private ListNode tail;



    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = middleNode(head);

        ListNode hS = reverseList(mid); //
        //mid.next = null;  //splitting  list into 2 - halves after reversal
        ListNode hf = head;




        // rearrange -- KK way Not Understand completely Now, need to revisit️🤯 -> 😍✅
        // in KK reversal 😁 reversal start from midNode itself. 😊 Also no need to splits in two halves Explicitly, Works same as IsPalindrome? in LL.

        while (hf != null && hS != null) {  // as second half of list Always smaller or equal in size that's why mostly terminate when (hS == null)

            // attaching
            ListNode temp = hf.next; // taking temp1 BcoZ we want to point to Next of "hf" before the merging happen.
            hf.next = hS;
            hf = temp;

            // for second - half
            temp = hS.next;   // Reuse temp to store next node of second-half before rewiring
            hS.next = hf;
            hS = temp;
        }

        // Loop terminates when second half is exhausted.
        // If one node remains in first half (odd length),
        // explicitly terminate it to avoid cycle.

        if (hf != null) {  // if this not become tail. In some cases(☠️ODD-length) become Circular List and during display() execution become infinite - loop.
            hf.next = null;
        }


       /*
       // ⚠️😵☠ ️This way only works when List being Explicitly Split in two halves after reversal and 🌟reversal must start from MiddleNode.next.
//        while (hS != null) { // as second half of list Always smaller or equal in size that's why terminate when (hS == null).
//            ListNode temp1 = hf.next;
//            ListNode temp2 = hS.next;
//
//            hf.next = hS;
//            hS.next = temp1;
//
//            hf = temp1;
//            hS = temp2;
//
//        }
//

        */


   }

    // insertLast
    public void insertLast (int val){
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = node;

    }


    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // reverse the List
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) { // next can give null pointer Exception
                next = next.next;
            }
        }
        return prev; // as  'prev' will point to the Head of reversed part of List.
    }



    // display fn
    public void display() {
        if (head == null) {
            System.out.println("List is Empty!");
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END.");
    }

    // structure of Node
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    // main fn
    public static void main(String[] args) {
        ReorderedLL_LC143 list = new ReorderedLL_LC143();
        for (int i = 1; i < 7; i++) {
            list.insertLast(i);
        }
        list.display();

        list.reorderList(list.head);
        System.out.println("After reordering the list..");
        list.display();
    }
}
