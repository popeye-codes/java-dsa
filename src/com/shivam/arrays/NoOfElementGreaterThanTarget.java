package com.shivam.arrays;

//Problem:
//Given an array of integers, find the number of elements greater than a given number x using recursion only (no loops).
//Input: arr = [3, 7, 2, 8, 5], x = 4
//Output: 3 → elements greater than 4 are 7, 8, 5

public class NoOfElementGreaterThanTarget {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 8, 5, 8, 0};
        int ans = count(arr);
        System.out.println(ans);
    }

    static int count(int[] arr) {
        return helper(arr, 0, 0, 4);
    }

    static int helper(int[] arr, int i, int count, int target) {

        if (i == arr.length) {
            return count;
        }

        if (arr[i] > target) {
            return helper(arr, i + 1, count + 1, target);
        }

        return helper(arr, i + 1, count, target);
    }
}
