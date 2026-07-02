package com.shivam.queues;

public class CustomQ_Main {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        // to insert one - item taking O(1)
        queue.insert(15);
        queue.insert(34);
        queue.insert(77);
        queue.insert(18);
        queue.insert(17);

        queue.display();

        queue.remove();  // to removing one - item taking O(n)

        queue.display();
    }
}
