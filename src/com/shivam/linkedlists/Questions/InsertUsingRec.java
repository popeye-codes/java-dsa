package com.shivam.linkedlists.Questions;



public class InsertUsingRec {

    private Node head;
    private Node tail;
    int size;

    public InsertUsingRec () {
        this.size = 0;
    }



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


    public void insertRec(int val, int index) {   // insert using Rec at an index
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {

        // base - case
        if (index == 0) {
            Node newNode = new Node(val, node);// we are doing {newNode.next = currentNode} is in current fn call but indirectly
            size ++;
            return newNode; // returning newly added node at Base - condition
        }

        if (index < 0 || index > size) {
            System.out.println("Invalid Index! Try again..");
            return null;
        }

        node.next = insertRec(val, index - 1, node.next); // currentNode.next = whatever you have returned.
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

    public static void main(String[] args) {
        InsertUsingRec list = new InsertUsingRec();
        list.insertFirst(17);
        list.insertFirst(18);
        list.insertFirst(333);
        list.insertFirst(175);
        list.insertFirst(300);

        list.display();
        list.insertRec(82, 3);
        list.display();
    }
}
