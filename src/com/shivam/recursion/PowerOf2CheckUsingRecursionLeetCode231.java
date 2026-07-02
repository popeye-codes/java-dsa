package com.shivam.recursion;

public class PowerOf2CheckUsingRecursionLeetCode231 {
    public static void main(String[] args) {
        int n = 16;
        boolean ans = check(n);
        System.out.println(ans);
    }

    static boolean check(int n){

        //Always check SUCCESS base condition before FAILURE condition in recursion. -> vvi

        if(n == 1 ) return true;

        if(n % 2 != 0 || n == 0) return false;

        return check(n/2);
    }
}
