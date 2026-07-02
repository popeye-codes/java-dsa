package com.shivam.stacks.Questions;

import java.util.Stack;


public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,4};
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // store index
        int max = 0; // needs to return

        for (int i = 0; i < heights.length; i++) {

            // POP → gives height
            // stack.peek() → left boundary
            // i or n → right boundary

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int width;
                int area
                        ;
                // pop and Calculate Area
                int popped = stack.pop();

                //WIDTH

                // stackEmpty => right_boundary is the width i.e; We've now the left boundary(smallest in left)
                // so to include left boundary till right boundary.
                if (stack.isEmpty()) width = i;
                else {
                    width = i - stack.peek() - 1;  // right - boundary - left boundary - 1
                }


                // AREA
                area = heights[popped] * width;

                max = Math.max(max, area);
            }
            stack.push(i);
        }

        // traverse complete array and if still have something in stack calculate area for each thar are in index
        int n = heights.length;
        while (!stack.isEmpty()) {

            int width;
            int area;
            // pop and Calculate Area
            int popped = stack.pop();


            // width logic is same as for - loop Width
            if (stack.isEmpty()) { // means we've now the left boundary(smallest in left) so to include left boundary till right boundary.
                //width
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }

            // Area
            area = heights[popped] * width;

            max = Math.max(max, area);

        }

        return max;
    }
}
