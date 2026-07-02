package com.shivam.linkedlists;


public class LL {
    private Node head;
    private Node tail;
    int size;
    public LL() {
        this.size = 0;
    }

    // < ---------------------------- INSERTION in Singly LL ---------------------------- >

    // insert at First
    public void insertFirst(int value) {
        Node newNode = new Node(value); // Creating a new object only when we want a new ListNode in Memory.

        if(tail == null) { // if there is no primary existing node
            head = newNode;
            tail = newNode;
            size += 1;
            return;
        }

        newNode.next = head;
        head = newNode;
        // tail = newNode.next; -> wrong

        size += 1;
    }

    // insert at Last
    public void insertLast(int value) {

        if (head == null) {
            insertFirst(value);
            return;
        }

        Node newNode = new Node(value);

        tail.next = newNode;
        tail = newNode;

        size += 1;
    }

    // insert at Any index
    public void insertAtIdx(int value, int idx) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid Index! Try again..");
            return;
        }

        if (idx == 0) { // insert at beginning
            insertFirst(value);
            return;
        }

        if (idx == size) {
            insertLast(value);
            return;
        }

        Node newNode = new Node(value);

        Node temp = head;
        for (int i = 1; i < idx; i++) { // for - loop
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size += 1;

    }

    // insert after a particular ListNode having a value
    public void insertAfter(int afterValue, int value) {

        Node prevNode = getForInsert(afterValue);

        if (prevNode == null) {
            System.out.println("ListNode not found.");
            return;
        }

        if (prevNode == tail) {
            insertLast(value);
            return;
        }

        Node newNode = new Node(value); // create newNode
        newNode.next = prevNode.next;
        prevNode.next = newNode;

        size += 1;
    }


    // get - fun
    public Node getForInsert(int afterValue) {
        Node node = head;
        while (node != null) {
            if (node.val == afterValue){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // < ---------------------------- DELETION in Singly LL ---------------------------- >

    // Deletion of ListNode
    public int deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return  -1;
        }
        int val = head.val;

        head = head.next;

        if (head == null) {
            tail = null;
        }

        size --;
        return val;
    }

    // Deletion of last ListNode
    public int deleteLast() {
        if (head == null) {
            System.out.println("Empty List");
            return -1;
        }
        if (head == tail) {
            return deleteFirst();
        }

        Node node = head;
        while (node.next != tail) {
            node = node.next;
        }

        int val = tail.val;
        node.next = null;
        tail = node;

        size --;
        return val;
    }

    // delete last node . Method - 2
    public int deleteLastMethod2 () {
        if(size <= 1) {
            return deleteFirst();
        }
        Node secondLast = getForDeletion(size - 2);
        if (secondLast == null) {
            return -1;
        }
        int val = tail.val;
        tail = secondLast;
        tail.next = null;

        size --;
        return val;
    }

    // deletion of node from any Index
    public int deleteAtIndex (int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid Index");
            return -1;
        }
        if (idx == 0) {
            return deleteFirst();
        }
        if (idx == (size - 1)) { // means at last idx
            return deleteLastMethod2();
        }

        Node prev = getForDeletion(idx - 1); // give me previous idx of which idx I want to delete
        int val = prev.next.val;
        prev.next = prev.next.next;

        size -= 1;
        return val;
    }
    public Node getForDeletion(int index) {
        Node node = head;
        for (int i = 0; i < index && node != null; i++) { // also check is node null?
            node = node.next;
        }
        return node;
    }


    // display fn
    public void display() {
        if (head != null) {
            Node temp = head; // temp is just a reference variable pointing to head, just use to move across the existing nodes

            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
            System.out.println("Size: " + size);
        }
    }

    private class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
