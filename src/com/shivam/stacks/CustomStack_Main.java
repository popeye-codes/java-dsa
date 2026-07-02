package com.shivam.stacks;

public class CustomStack_Main {
    public static void main(String[] args) throws StackException {  // "throws StackExceptio" adding this because something is available in main - fn that can throw Exception
        CustomStack stack = new CustomStack(5); // providing size => can only add 5 - items

        stack.push(17);
        stack.push(18);
        stack.push(333);
        stack.push(33);
        stack.push(19);

        System.out.println("Element at top of Stack: " + stack.peek());


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // now we are trying to pop - one more time will give Empty Stack Exception
        // beCoz stack only containing 5 - elements, and we are trying to remove 6th element

        //System.out.println(stack.pop());


    }
}
