package com.shivam.stacks;

public class DynamicStack_Main {
    public static void main(String[] args) throws StackException {
        //DynamicStack stack = new DynamicStack(5);

        // can also do like this
        CustomStack stack = new DynamicStack(5);


        stack.push(17);
        stack.push(18);
        stack.push(333);
        stack.push(33);
        stack.push(19);
        stack.push(10); // size is only 5 but pushing 6th element Will not give Error BeCoZ its Dynamic Sack.



        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
