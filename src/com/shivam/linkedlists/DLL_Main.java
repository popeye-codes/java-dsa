package com.shivam.linkedlists;

public class DLL_Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        System.out.println("Initial Size: " + list.size);
// <-------------------------------------- INSERTION -------------------------------------->
        System.out.println("Insertion below!!..");
        list.insertFirst(18);
        list.insertFirst(17);
        list.insertFirst(333);
        list.insertFirst(10);
        list.display();


        list.insertLast(7);
        list.insertLast(30);
        list.display();


        list.insertAfter(18, 25);
        list.display();

        // <-------------------------------------- DELETION -------------------------------------->
        System.out.println("\nDeletion below!!..");
        list.deleteFirst();
        list.display();


        list.deleteLast();
        list.display();


        list.deleteSpecific(25);
        list.display();
    }
}
