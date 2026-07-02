package com.shivam.linkedlists;

public class LL_Main {
    public static void main(String[] args) {
        LL list = new LL();
        System.out.println("Initial Size: " + list.size);
        System.out.println("Insertion..");
        // inserting at first
        list.insertFirst(18);
        list.insertFirst(333);
        list.insertFirst(17);
        list.insertFirst(7);
        list.insertFirst(10);
        list.display();

        // inserting at last Using tail
        list.insertLast(9);
        list.display();

        // insert at any idx
        list.insertAtIdx(30, 3);
        list.display();

        // insert after a ListNode having specific value
        list.insertAfter(333, 300);
        list.display();

        // <--------------- Deletion of ListNode ------------>

        System.out.println("Deletion!!");
        // delete first
        System.out.println(list.deleteFirst());
        list.display();

        //delete last
        System.out.println(list.deleteLast());
        list.display();

        // delete last M - 2
        System.out.println(list.deleteLastMethod2());
        list.display();

        // delete from particular index
        System.out.println(list.deleteAtIndex(2));
        list.display();

        System.out.println("Current Size of LL is: " + list.size); // will print actual LL size at present
    }
}
