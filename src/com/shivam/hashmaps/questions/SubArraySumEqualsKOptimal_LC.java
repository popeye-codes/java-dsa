package com.shivam.hashmaps.questions;


import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsKOptimal_LC {
    // A subarray is a contiguous non-empty sequence of elements within an array.

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int prefixSum = 0;

        /// Without this, subarrays starting from index 0 wouldn't be counted.
        map.put(prefixSum, 1); // (0, 1) -> initial push

        for (int num : nums) {

            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                // how many times "prefixSum - k" appears previously
                int freq = map.get(prefixSum - k);

                count += freq;
            }

            /// ultimately every prefixSum - need to go into Map.
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subarraySum(arr, 2));
    }
}