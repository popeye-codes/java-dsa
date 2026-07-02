package com.shivam.stacks;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super(); // it will call CustomStack(). i.e; Non - parametrised Constructor
    }

    public DynamicStack(int size) {
        super(size); // will call CustomStack(int size)
    }

    // in DynamicStack everything remain the same as CustomStack, only problem facing with push - fn
    // so if you want to use push of DynamicStack - class not of the Parent class CustomStack
    // Simply, @Override the push - method of Parent Class into Child Class

    @Override
    public boolean push(int item) {
        // this takes care of it being full
        if (this.isFull()) {
            // double the Array size
            int[] temp = new int[data.length * 2];

            // copy all previous item in new Doubled - size Array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i]; // copying
            }

            data = temp;
        }

        // at this point we know that Array is not full
        // So, that insert - item normally.
        return super.push(item);
    }
}
