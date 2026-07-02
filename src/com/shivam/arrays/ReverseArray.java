package com.shivam.arrays;

public class ReverseArray {
    public static void main (String[] args) {
       int[] arr = {1, 2, 3, 4, 5};
       int s = 0;
       int end = arr.length -1;
       reverse(arr, s, end); // fun call
    }

    public static void reverse (int[] arr, int start, int e) {
        while (start < e) {
            int temp = arr[start]; // 1
            arr[start] = arr[e]; // 0th index 5
            arr[e] = temp; //4th idx = 1

            start++;
            e--;
        }

        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
