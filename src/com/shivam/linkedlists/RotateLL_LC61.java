package com.shivam.linkedlists;


public class RotateLL_LC61 {
    private ListNode head;
    private ListNode tail;




    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last_node = head;
        int length = 1;
        while (last_node.next != null) {
            last_node = last_node.next;
            length +=1;
        }

        last_node.next = head;

        int rotation = k % length; // no. of times rotation
        int skip = length - rotation; // No. of times need to skip the nodes to 🌟reached at start of Sub-List

        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next; // after each rotation original last-node become new head after rotation
        newLast.next = null;

        return head;
    }


    // insert at last
    public void insertLast(int value) {
        ListNode newN = new ListNode(value);

        if (head == null) {
            head = newN;
            tail = newN;
            return;
        }

        tail.next = newN;
        tail = newN;

    }

    // display fun
    public void display(ListNode head) {

        if (head == null) {
            System.out.println("Empty..");
            return;
        }
        ListNode node = head;

        while (node != null) {
            System.out.print(node.val +" -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    // structure of ListNode
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        RotateLL_LC61 list = new RotateLL_LC61();
        for (int i = 0; i < 7; i++) {
            list.insertLast(i);
        }

        list.display(list.head);
        System.out.println("List after rotating: ");
        list.display(list.rotateRight(list.head, 2));
    }
}
