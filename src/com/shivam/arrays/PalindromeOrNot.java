package com.shivam.arrays;
//Given an integer n, check whether it is a palindrome using recursion only.
//
//A number is a palindrome if it reads the same forward and backward.
//
//        Examples
//Input:  12321
//Output: true

public class PalindromeOrNot {
    public static void main(String[] args) {
        int n = 12321;
        boolean ans = isPalindrome(n);
        System.out.println(ans);
    }
    static boolean isPalindrome(int n){

        if (n < 10) { // as Palindrome not consider negative number
            return true;
        }

        int noOf_digits = (int)Math.log10(n) + 1;
        int first = n / (int) Math.pow(10, noOf_digits - 1); // first digit
        int last = n % 10; // last digit

        int middle = (n % (int) Math.pow(10,noOf_digits -1 )) / 10; // shrinking from both side
        if (first == last) {
            return isPalindrome(middle);
        }
        return false;
   }
}

/*
Note :- 010 ❌ (doesn't exist) for int 

 */
