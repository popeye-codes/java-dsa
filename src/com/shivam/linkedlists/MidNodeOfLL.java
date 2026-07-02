package com.shivam.linkedlists;



public class MidNodeOfLL {

       Node head;
       Node tail;

        public static Node getMid(Node head) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public void insertFirst(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;

        }

        public void display () {

            if (head != null){
                Node temp = head;

                while (temp != null) {
                    System.out.print(temp.val +" -> ");
                    temp = temp.next;
                }
                System.out.println("END!.");
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

            MidNodeOfLL list = new MidNodeOfLL();
            list.insertFirst(1);
            list.insertFirst(2);
            list.insertFirst(3);
            list.insertFirst(4);
            list.insertFirst(1);
            list.display();


            Node mid = getMid(list.head);

            System.out.println(mid.val);
        }
    }


