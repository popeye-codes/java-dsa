package com.shivam.arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] arr = {3,2,7};
        int ans = product(arr,0,1);
        System.out.println(ans);
    }

    static int product(int[] arr, int i, int prod){
        if(i == arr.length) return prod;

        return product(arr, i + 1, prod * arr[i]);
    }
}

//LeetCode 231?

/*
Note:
as doing internally:

prod *= arr[i];


…but since Java variables are immutable inside function calls (pass-by-value), we simulate it by passing the updated value to the next call.
 */