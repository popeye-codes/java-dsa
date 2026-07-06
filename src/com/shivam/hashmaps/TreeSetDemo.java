package com.shivam.hashmaps;

import java.util.TreeSet;


///  TreeSet: called as Ordered Set & also contains only Unique - element
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(); /// Balanced BST - Data structure

        // insertion -> O(1)
        set.add(77);
        set.add(65);
        set.add(21);
        set.add(18);
        /// set.add(18); // set -> itself means only Unique - ele will be allowed => not inc. in size
        System.out.println(set.size());

        System.out.println(set.contains(21)); // contains ? -> O(1)

        // remove -> O(1)
       /// set.remove(21);

       /// System.out.println(set.contains(21));

        System.out.println(set);
    }
}
