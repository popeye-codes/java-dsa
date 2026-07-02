package com.shivam.recursion;

public class CountNoOfZeroByPassingArgument {
    public static void main(String[] args) {
        int n = 30201;
        int ans = count (n);
        System.out.println(ans);
    }
    
    static int count(int n) {

        return helper(n, 0);
    }

    // helper - fn

    static int helper( int n, int count) {
        if (n == 0){
            return count;
        }
        int rem = n % 10;

        if (rem == 0){
            return helper(n/10, count + 1);
        }
        return helper(n/10, count);
    }
}
