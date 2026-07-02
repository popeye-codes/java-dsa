package com.shivam.arrays;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int sum = display(0 ,arr);
        System.out.println(sum);
    }

    static int display(int i, int[] arr){
        if(i == arr.length -1 + 1) {
            return 0;
        }
        return display(i + 1, arr) + arr[i];
    }
}

