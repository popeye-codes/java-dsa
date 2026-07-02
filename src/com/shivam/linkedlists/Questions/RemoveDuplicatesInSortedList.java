package com.shivam.linkedlists.Questions;

public class RemoveDuplicatesInSortedList {
    Node head;
    Node tail;
    int size;

    public RemoveDuplicatesInSortedList() {
        this.size = 0;
    }

    public void insertFirst (int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size ++;
            return;
        }

        newNode.next = head;
        head = newNode;

        size ++;
    }


    // Main - Logic
    public void duplicate () {
        if (head == null) {
            System.out.println("list is empty!");
            return;
        }

        Node node = head;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;   //duplicate found => delete next// → stay on same node to Checking is there any further duplicate exist.
                size --;
            }
            else {
                node = node.next; // not found duplicate move to next node
            }
        }

        // in the end
        tail = node;
        tail.next = null;
    }

    public void display () {

        if (head != null){
           Node temp = head;

            while (temp != null) {
                System.out.print(temp.val +" -> ");
                temp = temp.next;
            }
            System.out.println("END!.");
            System.out.println("Size: " + size);
        }
    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedList list = new RemoveDuplicatesInSortedList();

        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(4);
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(1);
        list.insertFirst(1);

        list.display();

        list.duplicate();
        list.display();

    }

}
