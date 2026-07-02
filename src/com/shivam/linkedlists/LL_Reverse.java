package com.shivam.linkedlists;


public class LL_Reverse {
    private ListNode head;
    private ListNode tail;
    int size = 0;


    public void insertLast (int val){
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = node;
            size ++;
            return;
        }

        tail.next = node;
        tail = node;

        size ++;
    }


    // 🌟 reversing the LL recursively.

    public void reverse (ListNode node) {

        // base - case
        if (node.next == null) {
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next = node; // node is current node during returning the fun
        tail = node;
        tail.next = null;
    }


    // 🌟☠️ reverse LL without recursion ( 3 - pointer Approach )

    public void rev () {
        if (head == null) {
            return;
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
        head = prev;
    }



    // 🌟🌟LeetCode - 92
    public ListNode reverseBetween (ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // skip the first (left - 1) nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        // setting pointer to the node which are just from left and right side outside the range
        ListNode last = prev;
        ListNode newEnd = current;


        // reverse between left and right


        for (int i = 0; current != null && i < right - left + 1; i++) { // (right - left + 1) = no. of total nodes between the left & right
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

//            if (next != null) {
//                next = next.next;
//            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }


    // display - fn
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
        System.out.println("size: " + size);
    }
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // main - fn
    public static void main(String[] args) {
        LL_Reverse list = new LL_Reverse();

        for (int i = 0; i < 5; i++) {
            list.insertLast(i);
        }

        list.display();

//        list.reverse(list.head);
//
//        list.display();

//        list.rev();
//        list.display();

        list.reverseBetween(list.head,2, 4);
        list.display();

    }
}
