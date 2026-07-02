package com.shivam.recursion;

// Given an integer num, return the number of steps to reduce it to zero.
//In one step, if the current number is even, you have to divide it by 2, otherwise, you have to
// subtract 1 from it.

public class NoOfStepsToMakeZeroLC1342 {
    public static void main(String[] args) {
        int num = 123;
        int ans = numberOfSteps(num);
        System.out.println(ans);
    }

    static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    static int helper( int num, int count) {  // Real - recursion

        if(num == 0){
            return count;
        }

        if (num % 2 == 0){  // if num is Even No.
            return helper(num / 2, count + 1);
        }

        return helper(num - 1,  count + 1);  // if num is Odd No.
    }
}
