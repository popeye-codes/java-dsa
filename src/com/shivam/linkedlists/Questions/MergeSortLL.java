package com.shivam.linkedlists.Questions;


public class MergeSortLL {
    private ListNode head;
    private ListNode tail;


    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value); // Creating a new object only when we want a new ListNode in Memory.

        if(tail == null) { // if there is no primary existing node

            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    // display fn
    public void display() {
        if (head != null) {
            ListNode temp = head; // temp is just a reference variable pointing to head, just use to move across the existing nodes

            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {  // base - condition
            return head;
        }

        ListNode mid = getMid(head);

        ListNode rightHead = mid.next;

        // ⚠️ important to split the List in two halves
        mid.next = null;  // first split then do recursion - call.

        //recursive sort
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);


        return merge(left, right);
    }



    // merging Two sorted List
    private ListNode merge (ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(100); // fake head node in which we keep attaching the Sorted - ListNode

        // merging in O(1) space - complexity
        ListNode temp = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }

            else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        // attach the remaining ListNode
        if (list1 != null) {
            temp.next = list1;
        }
        else if (list2 != null) {
            temp.next = list2;
        }

        return dummyHead.next;
    }

    // finding mid
    private static ListNode getMid (ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MergeSortLL list = new MergeSortLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        list.display();

        // sortList returns the head of the newly sorted linked list,
        // so we assign it back to the original head reference
        list.head = list.sortList(list.head);

         list.display();

    }

}
