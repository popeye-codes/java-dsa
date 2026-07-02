package com.shivam.queues;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue() {  // constructor
        super();
    }

    public DynamicQueue(int size) {  // constructor
        super(size);
    }

    @Override
    public boolean insert(int item) {

        // this takes care of it being full
        if (this.isFull()) {
            // double the Array size
            int[] temp = new int[data.length * 2];

            // copy all previous item in new Doubled - size Array
            for (int i = 0; i < data.length; i++) {  // i = 0, means 0th item not from idx = 0, it's actually 0th item start copying from "front" till "end".

                temp[i] = data[(front + i) % data.length]; // 🌟🌟copying

            }

            front = 0;
            end = data.length;   // beCoz, we know array is full
            data = temp;
        }

        // at this point we know that Array is not full
        // So, that insert - item normally.
        return super.insert(item);
    }
}
