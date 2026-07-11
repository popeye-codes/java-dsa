package com.shivam.heaps.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<Integer> freqSort(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // to find frequency using HashMap
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>( (a, b) -> b.second - a.second );

        // iterate over Map - using Key
        for (int ele : map.keySet()) {
            int frequency = map.get(ele);
            maxHeap.offer(new Pair(ele, frequency));
        }


        while (!maxHeap.isEmpty()) {

            Pair p = maxHeap.poll();

            int num = p.first;    // get array - element
            int freq = p.second; // frequency of element

            // arranging all Occurrence in Sorted manner
            for (int i = 0; i < freq; i++) {
                ans.add(num); // add in List
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 1, 2, 2, 4};
        System.out.print("Original Array: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println("\nSorted Array: " + freqSort(arr));
    }
}
