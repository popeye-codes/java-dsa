package com.shivam.queues;

public class CircularQueue {
    protected int[] data;  // an Array
    private static final int DEFAULT_SIZE = 10;

    // pointer
    int end = 0;    // to insert
    int front = 0;  // to delete
    private int size = 0;


    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }


    public boolean isFull() {
        return size == data.length; // here "end" maYNot be equal to "data.length" in CircularQ ; that's why taking size here
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert (int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;  // first will assign value at end & then post - increment i.e; ++

        // "end" is always storing index numeric value
        end = end % data.length;  // when end is at Last-idx but 0th index is empty => end % data.length = 5 % 5 = 0 , means now "end" is at 0th index .
        size++;

        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty!!");
        }

        int removed = data[front++];  // remove data whom "front" is pointing
        front = front % data.length;
        size--;

        return removed;
    }

    // to know what element is at 0th idx
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty!!");
        }
        return data[front];
    }

    // display
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        int i = front;  // start display from "front" i.e; fist element of Queue
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i = i% data.length;  // to get the current idx value where "i" is pointing to
        } while (i != end);   // index val - "i" will compare to "end" that's containing idx numeric value
        System.out.println("END");
    }
}
