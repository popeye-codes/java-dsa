package com.shivam.stacks.Questions;

import java.util.Stack;

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        //stack.push(0); // initially in stack, pushing 0th index Element already

        for (int i = 0; i < heights.length; i++) {
            // stack going to contain all the increasing - order item till "i" exclude i
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) { //Condition where push - stop and start calculate
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        // when we traverse till end of index, Now calculate Area for every index that are in Stack
        int i = heights.length;  // "i" is at length of Array
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }
        return max;
    }

    private static int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        int area;

        int popped = stack.pop(); // top item of stack removed now calculate for this item
        if (stack.isEmpty()) {  // when stack become empty, "i" know that this is the smallest item - till "i"
            area = arr[popped] * i;  // then I can take it till "i" , entire one
        }
        else {

            // Right boundary kya hogi?
            //Current index i.
            //But rectangle i tak nahi ja sakta because:
            //heights[i] < heights[popped]
            //Isliye rectangle sirf yaha tak jayega:
            //i - 1

            //Left boundary
            //Pop hone ke baad stack ka top kya hai?
            //stack.peek()
            //Ye left side ka pehla smaller element hai.
            //Matlab rectangle is element ko include nahi kar sakta.
            //Rectangle start hoga:
            //stack.peek() + 1
            //Normal width formula:
            //width = right - left + 1
            //Put values:
            //right = i - 1
            //left = stack.peek() + 1
            //So:
            //width = (i - 1) - (stack.peek() + 1) + 1
            //Simplify:
            //width = (i - 1) - stack.peek()
            //Isi liye code me hai:
            //area = arr[popped] * ((i - 1
            // ) - stack.peek());

            area = arr[popped] * ((i - 1) - (stack.peek()));
        }
        return Math.max(max, area);  // max is being passed here during fn call of getMax
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int max_area = largestRectangleArea(heights);
        System.out.println(max_area);
    }
}
