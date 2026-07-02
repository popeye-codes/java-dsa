package com.shivam.linkedlists.Questions;



public class PalindromeCheckLL {
    private ListNode head;
    private ListNode tail;
    int size = 0;




    // is Palindrome?
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);

        ListNode headSecondHalf = rev(mid); // reversing list from mid.
        ListNode re_reverseHead = headSecondHalf;

        // compare both halves

        while (headSecondHalf != null) { // head is local head inside this fn
            if (head.val != headSecondHalf.val) {
                break;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        rev(re_reverseHead); // re - reversing

        return head == null || headSecondHalf == null; // means we have traversed til last => return true.
    }


    // find mid - node
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // reverse the List
    public static ListNode rev (ListNode head) {
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


    // insert at last
    public void insertLast(int value) {
        ListNode newN = new ListNode(value);

        if (head == null) {
            head = newN;
            tail = newN;
            size ++;
            return;
        }

        tail.next = newN;
        tail = newN;

        size ++;
    }

    // display fun
    public void display() {

        if (head == null) {
            System.out.println("Empty..");
            return;
        }
        ListNode node = head;

        while (node != null) {
            System.out.print(node.val +" -> ");
            node = node.next;
        }
        System.out.println("END");
        System.out.println("size: " + size);
    }
    // structure of ListNode
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // main - function
    public static void main(String[] args) {
        PalindromeCheckLL list = new PalindromeCheckLL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);

        list.display();

        boolean ans = list.isPalindrome(list.head);
        System.out.println(ans);



    }
}
