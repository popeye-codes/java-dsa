package com.shivam.recursion;


public class Nto1AndReverse {
    public static void main(String[] args) {
        fun(5); // N to 1
        funRev(5); // 1 to N
        funBoth(5);
    }

    static void fun(int n){
        if (n == 0) return;

        System.out.println(n);
        fun(n-1);
    }

    static void funRev(int n){
        if (n == 0) return;

        funRev(n-1);
        System.out.println(n);
    }

    static void funBoth(int n){
        if (n == 0) return;

        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }

}
