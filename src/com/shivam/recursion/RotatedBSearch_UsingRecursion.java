package com.shivam.recursion;

public class RotatedBSearch_UsingRecursion {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        int target = 3;
        int ans = search(arr, target, 0, arr.length - 1);
        System.out.println(ans);
    }

    static int search(int[] arr, int target, int s, int e ) {

        if (s > e) { // base - condition
            return -1;
        }

        int mid = s + (e - s)  / 2;

        if(arr[mid] == target){
            return mid;
        }

        if (arr[s] <= arr[mid]) { // => Sorted
            if(target >= arr[s] && target <= arr[mid]) { // target lie in LHS

                return search(arr, target, s, mid - 1 );
            }
            else {
                return search(arr, target, mid + 1, e);
            }
        }

        if (target >= arr[mid] && target <= arr[e]){

            return search(arr, target, mid + 1, e);
        }
        return search(arr, target, s, mid-1);
    }
}
