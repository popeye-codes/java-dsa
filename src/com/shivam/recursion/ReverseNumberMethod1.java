package com.shivam.recursion;


public class ReverseNumberMethod1 {
    public static void main(String[] args) {
        int n = 1342;
        rev(n);
        System.out.println(sum);
    }

    static int sum = 0;
    static void rev(int n) {
        if (n == 0) {
            return;
        }

        int l_digit = n % 10;
        sum = sum * 10 + l_digit;
        rev(n / 10);
    }
}
