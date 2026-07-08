package com.shivam.heaps.questions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KClosestNumber {

    // pairing in Heap
    static class  Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<Integer> closestNumber(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList<>();

        /// As I want to make first as Comparable So I do "Integer.compare(b.first, a.first) )"
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>( (a,b) -> Integer.compare(b.first, a.first) );


        ///  on insertion in Heap Each Pair look
//        Pair
//                +------------------+
//                | first  | second  |
//                +------------------+
//                | diff   | number  |
//                +------------------+

//        In your current problem:
//
//        Pair(diff, number)
//        first = diff ✅ (used for ordering)
//        second = number (stored for later)
//
//        So comparing first is correct.

        for(int num : arr) {
            int diff = Math.abs(num - x);
            maxHeap.offer(new Pair(diff, num));

            if (maxHeap.size() > k) {
                maxHeap.poll(); // will remove top
            }
        }

        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();

            //list.add(p.first);❌ beCoz we want second the array ele
            list.add(p.second);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;
        System.out.println(closestNumber(arr, k, x));
    }
}

