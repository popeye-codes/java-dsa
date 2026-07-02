package com.shivam.stacks;

public class CustomStack {
    protected int[] data;  // an Array
    private static final int DEFAULT_SIZE = 10;

    // pointer
    int ptr = -1;

    public CustomStack() { // if size not been provided, use the DEFAULT_SIZE.
        this(DEFAULT_SIZE);  // calling another Constructor with the Constructor
    }

    public CustomStack(int size) { // when size is being provided by user
        this.data = new int[size];
    }


    public boolean push (int item) {
        if (isFull()) {
            System.out.println("Stack is full!!");
            return false;
        }

        ptr++;  // increase ptr by 1
        data[ptr] = item; // insert item where "ptr" is pointing to.
        return true;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Can't pop from an empty sack!!");
        }
//        int removed = data[ptr]; // removed item will be top-most item pointed by ptr
//        ptr--;
//        return removed;    // returning the removed item

        // in Optimize way
        return data[ptr--]; // return data at ptr and then decrement
    }


    // peek means return What is at top of Stack.
    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Can't peek from an empty sack!!");
        }

        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length - 1; // ptr is at last index => stack is full as it's not dynamic
    }

    public boolean isEmpty() {
        return ptr == -1;
    }


}
