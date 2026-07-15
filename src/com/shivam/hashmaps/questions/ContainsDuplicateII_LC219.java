package com.shivam.hashmaps.questions;

import java.util.HashMap;

public class ContainsDuplicateII_LC219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {

                int j = map.get(nums[i]); // duplicate element index

                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            /// updating later after comparing with old one => not going to overwrite old value.
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(arr, k));
    }
}
