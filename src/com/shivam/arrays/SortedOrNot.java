package com.shivam.arrays;


//Given an array of integers, check whether the array is sorted in strictly increasing order using recursion only (no loops).
//
//Example
//Input:  [1, 3, 5, 7, 9]
//Output: true
//
//Input:  [1, 3, 2, 7, 9]
//Output: false
public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(check(arr, 0));
    }

    static boolean check(int[] arr, int i) {

        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] < arr[i + 1]) {
            return check(arr, i + 1);
        }
        return false;
    }
}
