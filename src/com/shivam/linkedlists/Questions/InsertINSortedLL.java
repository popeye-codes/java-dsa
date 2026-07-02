package com.shivam.linkedlists.Questions;

public class InsertINSortedLL {
    Node head;
    Node tail;
    int size;

    public InsertINSortedLL() {
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


    // Inserting in Sorted LL
    public void insertInSortLL (int n) {
        Node node = new Node(n);// creating a new ListNode with value = 4
        if (head == null) {
            head = node;
            tail = node;
            size ++;
            return;
        }

        if (n < head.val) {
            node.next = head;
            head = node;
            size ++;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.val < node.val) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;

        // if node is at tail So, insert at last
        if (node.next == null) {
            tail.next = node;
            tail = node;
        }


        size ++;
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
    }

    public static void main(String[] args) {
        InsertINSortedLL list = new  InsertINSortedLL();

        list.insertFirst(7);
        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(1);

        list.display();

        list.insertInSortLL(4);
        list.display();

    }
}
