package com.shivam.hashmaps;
import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // insertion -> O(1)
        set.add(77);
        set.add(65);
        set.add(21);
        set.add(18);
        /// set.add(18); // set -> itself means only Unique - ele will be allowed => not inc. in size
        System.out.println(set.size());

        System.out.println(set.contains(21)); // contains ? -> O(1)

        // remove -> O(1)
        set.remove(21);

        System.out.println(set.contains(21));

        System.out.println(set);
    }
}