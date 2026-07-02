package com.shivam.arrays;

public class FindMaxUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {6,7,9,0,1};
        int ans = find_Max(arr);
        System.out.println(ans);
    }

    static int find_Max(int[] arr){
        return helper(arr, 0, 0);
    }
    static int helper(int[] arr,int i, int max_index) {

        if (i == arr.length) {  // base - case
            return arr[max_index];
        }

        if (arr[i] > arr[max_index]){
           max_index= i;
        }
        return helper(arr, i + 1,  max_index);
    }
}
