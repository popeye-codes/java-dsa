package com.shivam.linkedlists.Questions;


public class BubbleSort_LL {
    private Node head;
    private Node tail;
    int size;
    public BubbleSort_LL() {
        this.size = 0;
    }



    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }
    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.val > second.val) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1); // get the previous ListNode
                    prev.next = second;
                    first.next = null;
                    second.next = first;
                    tail = first;
                } else {
                    Node prev = get(col - 1); // get the previous ListNode
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1); // rec - call to iterate over complete row with increment in col.
        }
        else {
            bubbleSort(row - 1, 0);
        }
    }


    // get - fn
    private Node get (int index) {
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return  prev;
    }


    // insert - at Last
    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            size ++;
            return;
        }

        tail.next = node;
        tail = node;

        size ++;
    }

    // display
    public void display () {

        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END.");
    }
    private class Node {
        int val;
        Node next;

        public Node (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BubbleSort_LL list = new BubbleSort_LL();

        for (int i = 5; i > 0; i--) {
            list.insertLast(i);
        }

        list.display();
        list.bubbleSort();
        list.display();

    }

}
