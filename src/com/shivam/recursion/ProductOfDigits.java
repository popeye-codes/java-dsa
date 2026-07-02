package com.shivam.recursion;

public class ProductOfDigits {
    public static void main(String[] args) {
        int n = 101;
        int product = digit_product(n);
        System.out.println(product);
    }

    static int digit_product(int n){

        if (n % 10 == n) return n; // base case - after eliminating L_digit one by one when we get n /= 10 => 0

        int n1 = n % 10; // to find out last_digit


        // Breaking Down into Two Smaller Problem i.e; (n1) + digit_sum(n / 10)
        return  (n1) * digit_product(n / 10) ;  // n = n / 10 ; is for remaining/ to eliminate last digit

    }
}
