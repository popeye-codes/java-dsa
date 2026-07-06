package com.shivam.hashmaps.questions;

import java.util.ArrayList;
import java.util.HashSet;

public class MissingElementInRange {
    public static ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for(int ele : arr) set.add(ele);

        for (int i = low; i <= high; i++) { // low to high => range
            if(!set.contains(i)) {
                list.add(i); /// add in list
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 11, 15};
        System.out.println(missingRange(arr, 10, 15));
    }
}
