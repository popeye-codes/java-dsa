package com.shivam.arrays;

//Statement
//Given an array of integers and a target value x, find the first index where x occurs in the array using recursion only.
//
//If the element is not present, return -1.
//
//Examples
//Input:  arr = [3, 7, 2, 8, 5, 2, 9], x = 2
//Output: 2
//
//Input:  arr = [3, 7, 2, 8, 5], x = 10
//Output: -1
public class FirstOccurIdx {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 8, 5, 2, 9};
        int target = 2;
        int found_idx = occurIdx(arr, 0, target);
        System.out.println(found_idx);
    }

    static int occurIdx(int[]arr, int i, int target) {
        if (i == arr.length ){ // base case
            return -1;
        }

        if (arr[i] == target) {
            return i;
        }
        return occurIdx(arr, i + 1, target);
    }
}
