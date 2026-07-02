package com.shivam.queues.questions;

import java.util.Stack;

public class QueueUsingStacks_LL {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacks_LL() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        // for insert in O(1)
        first.push(item);
    }

    public int remove() throws Exception {
        while (!first.isEmpty()) {
            int popped = first.pop(); // popped item from first
            second.push(popped);     // put it in second
        }

        int removed = second.pop();

        while (!second.isEmpty()) {
            int popped = second.pop(); // popped item from first
            first.push(popped);
        }

        return removed;
    }

    public int peek() throws Exception {
        while (first.isEmpty()) {
            int popped = first.pop(); // popped item from first
            second.push(popped);     // put it in second
        }

        int peeked = second.peek(); // peeking

        while (!second.isEmpty()) {
            int popped = second.pop(); // popped item from first
            first.push(popped);
        }

        return peeked;
    }

    public boolean isEmpty() {
        return first.isEmpty(); // as we are considering first as our main - stack so if first is empty means Our Queue is also Empty.
    }


    // main - fn
    public static void main(String[] args) throws Exception{
        QueueUsingStacks_LL stack = new QueueUsingStacks_LL();
        stack.add(76);
        stack.add(79);
        stack.add(74);
        stack.add(98);
        stack.add(72);
        System.out.println(stack.remove());

    }
}
