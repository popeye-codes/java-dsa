package com.shivam.linkedlists;

public class DLL {

    private Node head;
    int size;

    public DLL() {
        this.size = 0;
    }

// <-------------------------------------- INSERTION -------------------------------------->

    // Insert at first / in beginning
    public void insertFirst (int val) {

        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }
        head= newNode; // if (head === null) => inserting first ever ListNode

        size ++;
    }

    // Insert at last
    public void insertLast (int val) {

        Node newNode = new Node(val);
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;

        size ++;

    }

    // insert after a ListNode having particular value
    public void insertAfter (int after, int val) {

        Node current = find(after); // searching
        if (current == null) {
            System.out.println("ListNode does not exist!! No Insertion.");
            return;
        }

        Node node = new Node(val);

        node.next = current.next;
        node.prev = current;

        if (current.next != null) {
            current.next.prev = node;
        }

        current.next = node;

        size ++;
    }

    // <-------------------------------------- DELETION -------------------------------------->

    // deletion of first node
    public void deleteFirst () {

        if (head == null) {
            System.out.println("List is Empty!! Deletion cannot takes place");
            return;
        }
        head = head.next;
        if (head != null) { // ⚠️ Did correction after write by self.
            head.prev = null;
        }
        size --;
    }

    // deletion of last node
    public void deleteLast () {

        if (head == null) {
            System.out.println("List is Empty!! Deletion cannot takes place");
            return;
        }

        if (head.next == null) { // ⚠️ Did correction after write by self.
            head = null;
            size --;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        size --;
    }

    // deletion of any ListNode in list with a particular value
    public void deleteSpecific (int value) {

        Node searchNode = find(value); // searching
        if (searchNode == null) {
            System.out.println("ListNode does not exist! Deletion not performed.");
            return;
        }
        if (searchNode == head) {
            deleteFirst();
            return;
        }
        if (searchNode.next == null) {
            deleteLast();
            return;
        }

        searchNode.prev.next = searchNode.next;
        searchNode.next.prev = searchNode.prev;

        size --;

    }
    // get ListNode with a particular value
    private Node find (int value) {

        Node searchedNode = head;

        while (searchedNode != null) {
            if (searchedNode.val == value) {
                return searchedNode;
            }
            searchedNode = searchedNode.next;
        }
        return null;
    }

    // display fun
    public void display () {

        Node temp = head;
        // ListNode last = null;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
         //   last = temp;
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println("size: " + size);

//        System.out.println("In reverse..");
//
//        while (last != null) {
//            System.out.print(last.val + " -> ");
//            last = last.prev;
//        }
//
//        System.out.println("START");
//        System.out.println("size: " + size);
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
