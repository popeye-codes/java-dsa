package com.shivam.hashmaps.questions;
import java.util.*;

public class ValidAnagram {

//    public static boolean isAnagram(String s, String t) {
//
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        HashMap<Character, Integer> sMap = frequencyMap(s);
//        HashMap<Character, Integer> tMap = frequencyMap(t);
//
//        if (sMap.size() != tMap.size()) { // both map have same no. of unique keys.
//            return false;
//        }
//
//        for (Character ch : tMap.keySet()) {
//
//            if (!sMap.containsKey(ch)) { /// ch -> is not in s-String
//                return false;
//            }
//            if (!tMap.get(ch).equals(sMap.get(ch))) { ///  is frequency equal?
//                return false;
//            }
//        }
//        return true;
//    }
//
//    static HashMap<Character, Integer> frequencyMap(String str) {
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for(Character ch : str.toCharArray()) {
//
//            if(map.containsKey(ch)) {
//
//                map.put(ch, map.get(ch) + 1);
//
//            } else {
//
//                map.put(ch, 1);
//
//            }
//        }
//
//        return map;
//    }

    // ====== Optimal ========
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = frequencyMap(s);

        // iterate over t -> String
        for (Character ch : t.toCharArray()) {
            if (!sMap.containsKey(ch)) {
                /// key is not present in String -> t => immediately return false, no need to go further.
                return false;
            }
            sMap.put(ch, sMap.get(ch) - 1);  /// frequency - 1
        }

        for (int freq : sMap.values()) { // iterating on Map's value
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }

    static HashMap<Character, Integer> frequencyMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

}
