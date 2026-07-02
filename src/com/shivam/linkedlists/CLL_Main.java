package com.shivam.linkedlists;

public class CLL_Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        System.out.println("initial size: " + list.size);

        System.out.println(" ---------------------------- INSERTION in CIRCULAR LL ---------------------------- ");
        list.insertFirst(12);
        list.insertFirst(18);
        list.insertFirst(17);
        list.insertFirst(19);
        list.insertFirst(22);
        list.display();


        list.insertLast(333);
        list.display();


        list.insertAfter(17, 300);
        list.display();

        System.out.println(" ---------------------------- DELETION in CIRCULAR LL ---------------------------- ");
        list.deleteFirst();
        list.display();

        list.deleteLast();
        list.display();
    }
}
