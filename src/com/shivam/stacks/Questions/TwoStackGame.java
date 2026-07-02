package com.shivam.stacks.Questions;

import java.util.Arrays;

public class TwoStackGame {
    static int twoStack (int x, int[] a, int[] b) {
        return twoStack(x, a, b, 0, 0) - 1; // Helper - function
    }

    private static int twoStack(int x, int[] a, int[] b, int sum, int count) {
        if (sum > x) {
            return count;
        }

        if (a.length == 0 || b.length == 0) {
            return count;
        }

        // recursion - call easy - piZzy
        int ans1 = twoStack(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int ans2 = twoStack(x, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

        // return maximum one from left and right call
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 4, 6, 1};
        int[] b = {2, 1, 8, 5};
        int x = 10;  // limit

        // fun - call
        int ans = twoStack(x, a, b);
        System.out.println(ans);

    }
}
