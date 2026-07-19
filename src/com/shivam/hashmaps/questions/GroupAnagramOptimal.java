package com.shivam.hashmaps.questions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// strs = ["eat","tea","tan","ate","nat","bat"]
public class GroupAnagramOptimal {

    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chArr = str.toCharArray(); // gives primitive

            Arrays.sort(chArr);

            // char[] -> String
            String sorted = new String(chArr);  // now we have sorted String


            if (!map.containsKey(sorted))  {
                ArrayList<String> value = new ArrayList<>(); // makes new List
                value.add(str); // -> it return boolean => can't directly push this statement into Map.
                map.put(sorted, value);
            }
            else {
                /// grouped:--->

                ArrayList<String> existingListReference = map.get(sorted);

                existingListReference.add(str); /// inserting directly at the existing list - reference So,

                ///  this below put is not needed
                //map.put(sorted, existingListReference);
            }

        }
//        for (ArrayList<String> innerList : map.values()) {
//            result.add(innerList);
//        }
        result.addAll(map.values());

        return result;
    }


    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
