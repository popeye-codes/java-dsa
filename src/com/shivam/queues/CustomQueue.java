package com.shivam.queues;

public class CustomQueue {

    protected int[] data;  // an Array
    private static final int DEFAULT_SIZE = 10;

    // pointer
    int end = 0;  // we insert from end always that's why pointer named as "end". starting from index = 0.

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }


    public boolean isFull() {
        return end == data.length; // ptr is at last index => stack is full as it's not dynamic
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert (int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;  // first will assign value at end & then post - increment i.e; ++

        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty!!");
        }

        int removed = data[0];

        // shifting the elements to left
        for (int i = 1; i < end; i++) {  // start shifting from idx = 1, last element to be shifted where "end" will point to.

            data[i - 1] = data[i];  // for i = 1, put 1st idx elem at 0th idx

        }
        end--;  // end decrease after removal
        return removed;

    }

    // to know what element is at 0th idx
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty!!");
        }
        return data[0];
    }

    // display
    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

}

