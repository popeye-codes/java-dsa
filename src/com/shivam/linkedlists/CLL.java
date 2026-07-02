package com.shivam.linkedlists;

public class CLL {
    private Node head;
    private Node tail;
    int size;

    public CLL () {
        this.size = 0;
    }

    // < ---------------------------- INSERTION in CIRCULAR LL ---------------------------- >

    //insertion at first
    public void insertFirst (int value) {
        Node node = new Node(value); // crate new node

        if (head == null) {
            head = node;
            tail = node;
            size ++;
            return;
        }

        node.next = head;
        head = node;
        tail.next = head;

        size ++;
    }

    // insert at last
    public void insertLast(int val) {

        if (head == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);  // crate new node

        tail.next = node;
        node.next = head;
        tail = node;

        size ++;
    }

    // insert after a target node with a specific value.
    public void insertAfter(int target, int val) {
        Node searchedNode = find (target);

        if (searchedNode == null) {
            System.out.println("ListNode does not exist! No insertion done.");
            return;
        }

        if (searchedNode == tail) {
            insertLast(val);
            return;
        }

        Node node = new Node(val); // crate new node

        node.next = searchedNode.next;
        searchedNode.next = node;

        size ++;
    }

    // < ---------------------------- DELETION in CIRCULAR LL ---------------------------- >

    // delete the first node
    public void deleteFirst () {
        if (head == null) {
            System.out.println("Empty list! No deletion can be done.");
            return;
        }

        if (tail.next != null) {
            tail.next = head.next;
        }
        head = tail.next;

        size --;

    }

    // delete the last node
    public void deleteLast () {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) { // only one node exist
            head = null;
            tail = null;
            size --;
            return;
        }
        Node temp = head;

         while (temp.next != tail){
             temp = temp.next;
         }

        temp.next = tail.next;
        tail = temp;

        size --;

    }

    // delete node with a specific value
    public void deleteSpecific (int val) {
        Node target = find(val);

        if (target == null) {
            System.out.println("ListNode doesn't exist");
            return;
        }

        if (target == head) {
            deleteFirst();
            return;
        }

        if (target == tail) {
            deleteLast();
            return;
        }

        Node prev = head;

        while (prev.next != target) { // loop - over when "prev" will point to previous node of target.
            prev = prev.next;
        }

        prev.next = target.next;

        size --;

    }


    // finding node
    public Node find (int target) {
        if (head == null) return null; // as head = null => list is empty.

        Node temp = head;

        do {
            if (temp.val == target) {
                return temp;
            }
            temp = temp.next;
        }
        while (temp != head);
        return null;

    }


    // display fun
    public void display () {
        Node temp = head;

        if (head != null) {
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            while (temp != head); // stop at again reached at { temp = head }.
            System.out.println("Back to HEAD -> " + temp.val); // will show this is Circular LL
            System.out.println("size: " + size);
        }
    }
    // structure of ListNode
    private class Node {
        int val;
        Node next;

        public Node (int val) {
            this.val = val;
        }

        public Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
