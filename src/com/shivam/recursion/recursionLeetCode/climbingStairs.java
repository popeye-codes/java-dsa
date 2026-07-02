package com.shivam.recursion.recursionLeetCode;

public class climbingStairs {
    public static void main(String[] args) {
        int n = 3;
        int total_steps = stepCount(n);
        System.out.println(total_steps);
    }

    static int stepCount(int n){
        return helper(n);
    }
    static int helper(int n){

        if(n == 0){ // Suppose we are already at the top, so this is a valid way.
            return 1;
        }
        if (n < 0) return 0; // invalid path

        int oneStepAtaTime =  helper (n - 1);
        int twoStepAtaTime = helper(n - 2);
        return oneStepAtaTime + twoStepAtaTime;
    }
}

/*
static int climbFromStep(int current, int n) {
    if (current == n) return 1;      // reached top
    if (current > n) return 0;       // overshoot

    return climbFromStep(current + 1, n) + climbFromStep(current + 2, n);
}
*/