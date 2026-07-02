package com.shivam.recursion;

// Given an integer num, repeatedly add all its digits until the result has only one digit, and
// return it.
// LeetCode 258
public class AddDigitsLC258 {
    public static void main(String[] args) {
        int num = 83;
        int ans = add_digits(num);
        System.out.println(ans); // output = 11 = 1 + 1 = 2
    }

    static int add_digits(int num){

        if (num < 10) return num;

        int sum = 0;

        while (num > 0){
            sum += num % 10;
            num /= 10;
        }

        return add_digits(sum);
    }
}

// Recursion + iteration combo (very common in interviews)

/* Most important realization (you nailed it):

        “That’s why we are sending sum for next call, not num”

YES ✔
Because:

num is already destroyed by loop

sum is the new number

Problem wants to repeat on the new number

 */