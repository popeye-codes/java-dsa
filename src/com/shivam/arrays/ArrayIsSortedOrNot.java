package com.shivam.arrays;

public class ArrayIsSortedOrNot {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5};
        boolean ans = sorted(arr, 0);
        System.out.println(ans);
    }

    static boolean sorted(int[] arr, int i) {

        // base - case

        if (i == arr.length - 1) {
            return true;
        }

        return arr[i] < arr[i + 1] && sorted(arr, i + 1);
    }

}
